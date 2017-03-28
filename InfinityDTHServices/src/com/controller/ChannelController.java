package com.controller;

import java.io.IOException;
//import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.bean.Channel;
//import com.service.ChannelService;
//import com.util.DBConnection;


@WebServlet("/ChannelController")
public class ChannelController extends HttpServlet {
	
	private static final long serialVersionUID = -6425906346960789918L;
	//private static final Logger logger = LogManager.getLogger(DBConnection.class);
	
	public ChannelController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Possibly fill this part out as needed
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create channel object to hold input form data locally
		Channel channel = new Channel();
		//ChannelService service = new ChannelService();		
		
		// filling operator class variables from input form
		channel.setName(request.getParameter("channelName"));
		channel.setBand(request.getParameter("channelBand"));
		channel.setVideoCarrierFrequency((Double.parseDouble(request.getParameter("videoCarrierFreq"))));		
		channel.setAudioCarrierFrequency(Double.parseDouble((request.getParameter("audioCarrierFreq"))));
		
		String channelType = request.getParameter("channelChargeType");		
		boolean free;
		if(channelType == "FTA (Free to Air)")
		{
			free = true;
		}
		else
		{
			free = false;
		}
		channel.setChannelChargeTypeFree(free);
		
		String transmissionType = request.getParameter("channelTransType");
		boolean standard;
		if(transmissionType == "Standard")
		{
			standard = true;
		}
		else
		{
			standard = false;
		}
		channel.setChannelTransmissionTypeStandard(standard);		
		channel.setCharge(Double.parseDouble(request.getParameter("channelCharge")));		

    }	
}
