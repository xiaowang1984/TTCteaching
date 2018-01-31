package auto;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import util.Column;
import util.ID;
import util.Table;

public class AutoDao {
	public static void createInterface(){
		String interfile=AutoUtil.BEAN+"Dao.java";
		File daoPath=new File(AutoUtil.DAOPATH);
		File inter=new File(daoPath, interfile);
		if(inter.exists()){
			System.out.println("dao接口文件已经存在");
		}else{
			try {
				inter.createNewFile();
				System.out.println("接口文件生成成功");
				File interpath=new File(AutoUtil.TMP, AutoUtil.DAOINTERFILE);
				String str= FileUtils.readFileToString(interpath, "UTF-8");
				String result = str.replaceAll("\\[Bean\\]", AutoUtil.BEAN)
					.replaceAll("\\[bean\\]", AutoUtil.SMALLBEAN);
				FileUtils.writeStringToFile(inter, result, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void createMapper(){
		String interfile=AutoUtil.BEAN+"Dao.xml";
		File daoPath=new File(AutoUtil.MAPPERPATH);
		File inter=new File(daoPath, interfile);
		String tableName=AutoUtil.SMALLBEAN;
		StringBuilder resultMap=new StringBuilder();
		List<String> fieldList=new ArrayList<>();
		StringBuilder insertField=new StringBuilder();
		StringBuilder insertValue=new StringBuilder();
		StringBuilder updateField=new StringBuilder();
		if(inter.exists()){
			System.out.println("Mapper文件已经存在");
		}else{
			try {
				inter.createNewFile();
				System.out.println("mapper文件创建完成");
				Class clz=Class.forName(AutoUtil.PACK+"."+AutoUtil.BEAN);
				//通过反射获取注解
				Annotation ann = clz.getDeclaredAnnotation(Table.class);
				//判断注解是否为空
				if(ann!=null){
					Table table= (Table)ann;
					tableName=table.value();
				}
				//通过反射获取到 类下的所有属性
				 Field[] fields = clz.getDeclaredFields();
				 for (Field field : fields) {
					 String columnName=field.getName();
					Column column = field.getDeclaredAnnotation(Column.class);
					if(column!=null){
						columnName=column.value();
					}
					resultMap.append("<result column=\""+columnName+"\" property=\""+field.getName()+"\"></result>\n");			
					fieldList.add(columnName);
					ID id= field.getDeclaredAnnotation(ID.class);
					if(id==null){
						insertField.append("<if test=\""+field.getName()+"!=null\">\n");
						insertField.append(columnName+",\n");
						insertField.append("</if>\n");
						insertValue.append("<if test=\""+field.getName()+"!=null\">\n");
						insertValue.append("#{"+field.getName()+"},\n");
						insertValue.append("</if>\n");
						updateField.append("<if test=\""+field.getName()+"!=null\">\n");
						updateField.append(columnName+"=#{"+field.getName()+"},\n");
						updateField.append("</if>\n");
					}
					
				 }
				File interpath=new File(AutoUtil.TMP, AutoUtil.MAPPERFILE);
				String str= FileUtils.readFileToString(interpath, "UTF-8");
				String result = str.replaceAll("\\[Bean\\]", AutoUtil.BEAN)
					.replaceAll("\\[bean\\]", AutoUtil.SMALLBEAN)
					.replaceAll("\\[resultMap\\]", resultMap.toString())
					.replaceAll("\\[table\\]", tableName)
					.replaceAll("\\[field\\]", fieldList.toString().replaceAll("\\[", "").replaceAll("\\]", ""))
					.replaceAll("\\[insertField\\]", insertField.toString())
					.replaceAll("\\[insertValue\\]", insertValue.toString())
					.replaceAll("\\[updateField\\]", updateField.toString());
				FileUtils.writeStringToFile(inter, result, "UTF-8");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
