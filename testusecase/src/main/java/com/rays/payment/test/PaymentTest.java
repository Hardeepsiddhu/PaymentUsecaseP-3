package com.rays.payment.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.payment.model.PaymentModel;
import com.rays.paymentdto.PaymentDTO;

public class PaymentTest {

	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
		//testfindByPk();
		testSearch();
	}


		private static void testSearch() {
			PaymentDTO dto = new PaymentDTO();
			dto.setPayer("nikhil");
			PaymentModel model = new PaymentModel();
			 List  list= model.search(dto, 0, 0);
			 Iterator it=list.iterator();
			 while (it.hasNext()) {
				 PaymentDTO dto1=(PaymentDTO) it.next();
				 System.out.println(dto1.getId());
					System.out.println(dto1.getPaymentDate());
					System.out.println(dto1.getDescription());
					System.out.println(dto1.getAmount());
					System.out.println(dto1.getPaymentMethod());
					System.out.println(dto1.getStatus());
					System.out.println(dto1.getPayer());
				} 

		}
		
	


		private static void testfindByPk() {
			PaymentModel model = new PaymentModel();
			PaymentDTO dto = model.findByPk(3);
			
			System.out.println(dto.getId());
			System.out.println(dto.getPaymentDate());
			System.out.println(dto.getDescription());
			System.out.println(dto.getAmount());
			System.out.println(dto.getPaymentMethod());
			System.out.println(dto.getStatus());
			System.out.println(dto.getPayer());
			
		
	}


	private static void testDelete() throws Exception {
		
		PaymentDTO dto = new PaymentDTO();
		
		dto.setId(1);
		
		PaymentModel model = new PaymentModel();
		model.delete(dto);

		
	}

	private static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PaymentDTO dto = new PaymentDTO();
		dto.setId(1);
		dto.setPaymentDate(sdf.parse("2022-03-10") );
		dto.setDescription("coaching");
		dto.setAmount(22000);
		dto.setPaymentMethod("cash");
		dto.setStatus("completed");
		dto.setPayer("hardeep singh");
		PaymentModel model = new  PaymentModel();
		model.update(dto);
		
	}

	private static void testAdd() throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PaymentDTO dto = new PaymentDTO();
		
		dto.setPaymentDate(sdf.parse("2022-03-10") );
		dto.setDescription("coaching");
		dto.setAmount(22000);
		dto.setPaymentMethod("cash");
		dto.setStatus("completed");
		dto.setPayer("nikhil kumar");
		 PaymentModel model = new PaymentModel();
		 model.add(dto);
				
	}
	
	
}
