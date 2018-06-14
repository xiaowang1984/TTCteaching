package com.neuedu.service.course;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import com.neuedu.util.Message;
import com.neuedu.dao.CourseDao;
import com.neuedu.dao.PlanDao;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.Plan;

@RestController
@RequestMapping("/course")
public class CourseServiceImpl implements IcourseService {
	@Autowired
	private CourseDao dao;
	@Autowired
	private PlanDao planDao;

	@Override
	@RequestMapping("/list")
	public ResultData getCourses(Course course) {
		// TODO Auto-generated method stub
		course.setOrderBy("name");
		course.setWithPage(0);
		return new ResultData(dao.getCourses(course),
				dao.getCount(course), course.getPageSize(), course.getPageNo());
	}

	@Override
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Message add(MultipartFile logo, Course course) {
		// TODO Auto-generated method stub
		try {
			ClassPathResource resource=new ClassPathResource("fdfs_client.conf");
			ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
			TrackerClient trackerClient=new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageClient1 client=new StorageClient1(trackerServer, null);
			byte[] b=logo.getBytes();
			String img=client.upload_file1(b, FilenameUtils.getExtension(logo.getOriginalFilename()),null );
			course.setImg(img);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Message(dao.add(course));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(MultipartFile logo,Course course) {
		if(logo!=null){
			ClassPathResource resource=new ClassPathResource("fdfs_client.conf");
			try {
				ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
				TrackerClient trackerClient=new TrackerClient();
				TrackerServer trackerServer = trackerClient.getConnection();
				StorageClient1 client=new StorageClient1(trackerServer, null);
				byte[] b=logo.getBytes();
				String img=client.upload_file1(b, FilenameUtils.getExtension(logo.getOriginalFilename()),null );
				course.setImg(img);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		return new Message(dao.update(course));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Course getCourseById(Course course) {
		// TODO Auto-generated method stub
		return dao.getCourseById(course);
	}

	@Override
	@RequestMapping(value="/getCourses")
	public List<Course> getAll(Course course) {
		// TODO Auto-generated method stub
		course.setWithPage(0);
		course.setIsDel(1);
		List<Course> courses=dao.getCourses(course);
		for (Course course2 : courses) {
			Plan plan=new Plan();
			plan.setWithPage(0);
			plan.setCId(course2.getId());
			course2.setPlans(planDao.getPlans(plan));
		}
		return courses;
	}

	@Override
	@RequestMapping(value="/getCourseByGid")
	public List<Course> getCourseByGid(int gId) {
		// TODO Auto-generated method stub
		return dao.getComputerCourse(gId);
	}
	
	
}
