package com.neuedu.service.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import com.neuedu.util.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.util.Message;
import com.neuedu.dao.OptionsDao;
import com.neuedu.dao.TestsDao;
import com.neuedu.pojo.Options;
import com.neuedu.pojo.Student;
import com.neuedu.pojo.Tests;

@RestController
@RequestMapping("/tests")
public class TestsServiceImpl implements ItestsService {
	@Autowired
	private TestsDao dao;
	@Resource
	private OptionsDao optionDao;

	@Override
	@RequestMapping("/list")
	public ResultData getTestss(Tests tests) {
		// TODO Auto-generated method stub
		return new ResultData(dao.getTestss(tests),
				dao.getCount(tests), tests.getPageSize(), tests.getPageNo());
	}

	@Override
	@RequestMapping("/add")
	public Message add(Tests tests) {
		// TODO Auto-generated method stub
		return new Message(dao.add(tests));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Message update(Tests tests) {
		// TODO Auto-generated method stub
		return new Message(dao.update(tests));
	}

	@Override
	public Message del(int id) {
		// TODO Auto-generated method stub
		return new Message(dao.del(id));
	}

	@Override
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public Tests getTestsById(Tests tests) {
		// TODO Auto-generated method stub
		return dao.getTestsById(tests);
	}
	
	@RequestMapping("/options")
	public List<Options> getOptions(Options option){
		return optionDao.getOptionss(option);
	}
	
	@RequestMapping(value="/upload")
	@Transactional
	public Message studentUpload(MultipartFile sfile, Integer qId){
		try {
			List<Tests> list=new ArrayList<>();
			HSSFWorkbook workbook=new HSSFWorkbook(sfile.getInputStream());
			HSSFSheet sheet = workbook.getSheetAt(0);
			int count=1;
			Row row=null;
			int result=0;
			while((row= sheet.getRow(count++))!=null){
				List<Options> options=new ArrayList<>();
				if(row.getCell(0)==null||row.getCell(0).toString().trim().equals(""))
					break;
				Tests tests=new Tests();
				tests.setName(row.getCell(1).toString().trim());
				List<String> skills=new ArrayList<>();
				if(row.getCell(8)!=null&&!row.getCell(8).toString().trim().equals(""))
					skills.add(row.getCell(8).toString().trim());
				if(row.getCell(9)!=null&&!row.getCell(9).toString().trim().equals(""))
					skills.add(row.getCell(9).toString().trim());
				if(row.getCell(10)!=null&&!row.getCell(10).toString().trim().equals(""))
					skills.add(row.getCell(10).toString().trim());
				if(skills.size()>0){
					tests.setSkill(String.join(",", skills));
				}
				tests.setFacility(StringUtils.trimToEmpty(String.valueOf(row.getCell(11))));
				tests.setAnalysis(StringUtils.trimToEmpty(String.valueOf(row.getCell(12))));
				tests.setQId(qId);
				result+=dao.add(tests);
				if(row.getCell(2)!=null&&!row.getCell(2).toString().trim().equals("")){
					Options option=new Options();
					option.setName(row.getCell(2).toString().trim());
				    option.setTId(tests.getId());
				    if(Arrays.binarySearch(row.getCell(7).toString().trim().toCharArray(), 'A')>=0)
				    	option.setIsRight(1);
				    options.add(option);
				}
				if(row.getCell(3)!=null&&!row.getCell(3).toString().trim().equals("")){
					Options option=new Options();
					option.setName(row.getCell(3).toString().trim());
				    option.setTId(tests.getId());
				    if(Arrays.binarySearch(row.getCell(7).toString().trim().toCharArray(), 'B')>=0)
				    	option.setIsRight(1);
				    options.add(option);
				}
				if(row.getCell(4)!=null&&!row.getCell(4).toString().trim().equals("")){
					Options option=new Options();
					option.setName(row.getCell(4).toString().trim());
				    option.setTId(tests.getId());
				    if(Arrays.binarySearch(row.getCell(7).toString().trim().toCharArray(), 'C')>=0)
				    	option.setIsRight(1);
				    options.add(option);
				}
				if(row.getCell(5)!=null&&!row.getCell(5).toString().trim().equals("")){
					Options option=new Options();
					option.setName(row.getCell(5).toString().trim());
				    option.setTId(tests.getId());
				    if(Arrays.binarySearch(row.getCell(7).toString().trim().toCharArray(), 'D')>=0)
				    	option.setIsRight(1);
				    options.add(option);
				}
				if(row.getCell(6)!=null&&!row.getCell(6).toString().trim().equals("")){
					Options option=new Options();
					option.setName(row.getCell(6).toString().trim());
				    option.setTId(tests.getId());
				    if(Arrays.binarySearch(row.getCell(7).toString().trim().toCharArray(), 'E')>=0)
				    	option.setIsRight(1);
				    options.add(option);
				}
				for (Options option : options) {
					result+=optionDao.add(option);
				}
			}

			return new Message(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(0);
		}
	}
	
}
