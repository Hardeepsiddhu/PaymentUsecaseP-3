package com.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.model.PaymentModel;
import com.rays.paymentdto.PaymentDTO;

@WebServlet("/PaymentCtl")
public class PaymentCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PaymentDTO dto = null;
		PaymentModel model = new PaymentModel();
		String id = req.getParameter("id");
		if (id != null) {
			dto = model.findByPk(Integer.parseInt(id));
			req.setAttribute("dto", dto);
		}
		RequestDispatcher rd = req.getRequestDispatcher("PaymentView.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String id = req.getParameter("id");
		PaymentModel model = new PaymentModel();
		PaymentDTO dto = new PaymentDTO();
		try {
			dto.setPaymentDate(sdf.parse(req.getParameter("PaymentDate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setDescription(req.getParameter("Description"));
		dto.setAmount(Integer.parseInt(req.getParameter("amount")));
		dto.setPaymentMethod(req.getParameter("paymentmethod"));
		dto.setStatus(req.getParameter("Status"));
		dto.setPayer(req.getParameter("payer"));
		
		String op = req.getParameter("operation");
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("msg", "User Updated Successfully...!!");
			req.setAttribute("dto", dto);
			System.out.println("............................");
			RequestDispatcher rd = req.getRequestDispatcher("PaymentView.jsp");
			rd.forward(req, resp);
		} else if (op.equalsIgnoreCase("save")) {
			model.add(dto);
			req.setAttribute("msg","payment Added" );
			RequestDispatcher rd = req.getRequestDispatcher("PaymentView.jsp");
			rd.forward(req, resp);
		}else if (op.equalsIgnoreCase("AddUser")) {
			resp.sendRedirect("PaymentView.jsp");
			
		}else if (op.equalsIgnoreCase("cancel")) {
			resp.sendRedirect("PaymentListCtl");
          
		}

	}
	}

