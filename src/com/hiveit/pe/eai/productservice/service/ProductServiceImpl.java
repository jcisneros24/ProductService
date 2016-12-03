package com.hiveit.pe.eai.productservice.service;

import com.hiveit.pe.eai.productservice.bean.ProductBeanRequest;
import com.hiveit.pe.eai.productservice.bean.ProductBeanResponse;
import com.hiveit.pe.eai.productservice.dao.XrootDaoImpl;
import com.hiveit.pe.eai.productservice.exception.DBException;
import com.hiveit.pe.eai.productservice.util.Constantes;

public class ProductServiceImpl implements ProductService {
	
	XrootDaoImpl xrootDaoImpl;
	Constantes propertiesInterno;
	@Override
	public String actualizarCodigo(String codOld, String codNew) {
		String response = null;
		ProductBeanResponse productBeanResponse = null;
		try {
			productBeanResponse = new ProductBeanResponse();
			
			if ((!codOld.isEmpty() || codOld != null) && (!codNew.isEmpty() || codNew != null)) {
				ProductBeanRequest productBeanRequest = new ProductBeanRequest();
				productBeanRequest.setCodArtiOld(codOld);
				productBeanRequest.setCodArtiNew(codNew);
				productBeanResponse = xrootDaoImpl.updateProduct(productBeanRequest);
				
				String codRpta = productBeanResponse .getCodRpta();
				
				if(propertiesInterno.COD_EXITO.equals(codRpta)){
					response = "Operacion exitosa";
				}else{
					response = "No se pudo Actualizar el producto.";
				}
			} 
			else {
				response = "Error en la validacion de campos";
			}
		}catch (DBException e) {
			response = e.getCode();
			response = e.getMessage();
		}catch (Exception e) {
			response = "{Error en el flujo del proceso: }"+e.getMessage();
		}
		return response;
	}

}
