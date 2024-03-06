package com.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.model.PaymentModel;
import com.rays.paymentdto.PaymentDTO;
@WebServlet("/PaymentListCtl")
public class PaymentListCtl extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo=1;
		int pageSize=10;
		String op=req.getParameter("operation");
		PaymentDTO	dto=null;
		PaymentModel model=new PaymentModel();
		List list=model.search(dto,0,0);
		
		RequestDispatcher rd=req.getRequestDispatcher("PaymentListView.jsp");
		req.setAttribute("List", list);
		rd.forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int pageNo=1;
		int pageSize=10;
		String op=req.getParameter("operation");
		
		PaymentDTO dto=null;
		PaymentModel model= new PaymentModel();
		System.out.println("hardeeep..");
		
		if (op!=null && op.equalsIgnoreCase("search")) {
			System.out.println("yessss");
		     dto=new PaymentDTO();
		     try {
					dto.setPaymentDate(sdf.parse(req.getParameter("PaymentDate")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dto.setDescription(req.getParameter("Description"));
				dto.setAmount(Integer.parseInt("amount"));
				dto.setPaymentMethod(req.getParameter("paymentmethod"));
				dto.setStatus(req.getParameter("Status"));
				dto.setPayer(req.getParameter("payer"));
		}
		if (op.equalsIgnoreCase("delete")) {
			System.out.println("pahuch gya hu");
			String[] ids=req.getParameterValues("ids");
			for (String id : ids) {
				PaymentDTO dto1=new PaymentDTO();
				dto1.setId(Integer.parseInt(id));
				model.delete(dto1);
			}
			
		}
			List list=model.search(dto,0,0);
			System.out.println("yes222.");
			req.setAttribute("List", list);
			RequestDispatcher rd=req.getRequestDispatcher("PaymentListView.jsp");
			rd.forward(req, resp);
			


		}
	}

