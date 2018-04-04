package test;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.dao.GradeDao;
import com.neuedu.pojo.Grade;
import com.neuedu.pojo.Student;
import com.neuedu.service.grade.IgradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class T {
	public static void main(String[] args) {
		char[] a={'A','B','C'};
		System.out.println(Arrays.binarySearch(a, 'T'));
		
	}
	@Resource
	private GradeDao service;
	
	@Test
	public void handler(){
		for(int i=101;i<=200;i++){
			Grade grade=new Grade();
			grade.setId(i);
			grade.setLecturer(i%6);
			System.out.println(service.update(grade));
		}
	}
}
