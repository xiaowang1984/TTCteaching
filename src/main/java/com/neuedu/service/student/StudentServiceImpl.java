package com.neuedu.service.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.transaction.annotation.Transactional;
import com.neuedu.util.Message;
import com.neuedu.dao.GradeDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Student;

@RestController
@RequestMapping("/student")
public class StudentServiceImpl implements IstudentService {
	@Autowired
	private StudentDao dao;

	@Override
	@RequestMapping("/list")
	public ResultData getStudents(Student student) {
		// TODO Auto-generated method stub
		student.setOrderBy("no asc");
		student.setWithPage(0);
		return new ResultData(dao.getStudents(student),
				dao.getCount(student), student.getPageSize(), student.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Student student) {
		// TODO Auto-generated method stub
		return new Message(dao.add(student));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Student student) {
		// TODO Auto-generated method stub
		return new Message(dao.update(student));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Student getStudentById(Student student) {
		// TODO Auto-generated method stub
		return dao.getStudentById(student);
	}
	
	@RequestMapping(value="/upload")
	@Transactional
	public Message studentUpload(MultipartFile sfile, Integer gid){
		try {
			List<Student> list=new ArrayList<>();
			HSSFWorkbook workbook=new HSSFWorkbook(sfile.getInputStream());
			HSSFSheet sheet = workbook.getSheetAt(0);
			int count=4;
			Row row=null;
			while((row= sheet.getRow(count++))!=null){
				if(row.getCell(3)==null||row.getCell(3).toString().trim().equals(""))
					break;
				Student student=new Student();
				float no=Float.parseFloat(row.getCell(3).toString().trim());
				student.setNo(Math.round(no));
				student.setGId(gid);
				student.setName(row.getCell(4).toString());
				if(row.getCell(5).toString().trim().equals("男"))
					student.setGender(1);
				else 
					student.setGender(0);
				student.setNation(row.getCell(6).toString());
				student.setSale(row.getCell(8).toString());
				student.setSchool(row.getCell(9).toString());
				student.setSpecialty(row.getCell(10).toString());
				student.setEducation(row.getCell(12).toString());
				row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
				student.setPhone(row.getCell(16).getStringCellValue());
				student.setAddress(row.getCell(17).toString());
				row.getCell(18).setCellType(Cell.CELL_TYPE_STRING);
				student.setWeChar(row.getCell(18).getStringCellValue());
				student.setRoomNo(row.getCell(19).toString());
				row.getCell(21).setCellType(Cell.CELL_TYPE_STRING);
				student.setQq(row.getCell(21).getStringCellValue());
				student.setEmail(row.getCell(22).toString());
				row.getCell(23).setCellType(Cell.CELL_TYPE_STRING);
				student.setIdCard(row.getCell(23).getStringCellValue());
				student.setCycle(row.getCell(24).toString());
				if(row.getCell(25).toString().trim().equals("是"))
					student.setRefund(1);
				else
					student.setRefund(0);
				list.add(student);
			}
			int result=bathUpdate(list);
			return new Message(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0);
		}
	}
	@Transactional
	public synchronized int bathUpdate(List<Student> list) {
		// TODO Auto-generated method stub
		int result=0;
		for (Student student : list) {
			Student studentQuery=new Student();
			studentQuery.setWhere("id_card='"+student.getIdCard().trim()+"'");
			if(dao.getCount(studentQuery) !=0)
				result+=dao.updateByIdCard(student);
			else
				result+=dao.add(student);
		}
		return result;
	}
	
}
