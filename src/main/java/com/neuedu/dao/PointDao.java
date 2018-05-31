package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Point;

public interface PointDao {
	public List<Point> getPoints(Point point);
	public int add(Point point);
	public int update(Point point);
	public int del(int id);
	public Point getPointById(Point point);
	public int getCount(Point point);
	
}