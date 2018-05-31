package com.neuedu.service.point;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Point;
import com.neuedu.util.ResultData;

public interface IpointService {
	public ResultData getPoints(Point point);
	public Message add(Point point);
	public Message update(Point point);
	public Message del(int id);
	public Point getPointById(Point point);
}
