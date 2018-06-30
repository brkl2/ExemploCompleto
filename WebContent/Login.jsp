<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pessoa</title>
</head>
<f:view>
	<h:form>
		<table>
		<center>
			<tr>
			
			
				<td><h:outputLabel value="Login"></h:outputLabel></td>
				<td><h:inputText value="#{pessoaController.pessoa.nome}"></h:inputText></td>
			</tr>
             </center>
             <center>
			<tr>
			
				<td><h:outputText value="Senha "></h:outputText></td>
				<td><h:inputText
						value="#{pessoaController.pessoa.senha}"></h:inputText></td>
			</tr>
               </center>
               <center>
			<tr>
				<td><h:commandButton value="Entrar"
						action="#{pessoaController.omegalul}"></h:commandButton></td>
				<td></td>
				</center>
			</tr>
		</table>

		<style> <div class="div-align-center">
                                <img id="mano.png" src="mano.png" alt="Logo">
                        </div> </style>
                        
	</h:form>
</f:view>
</html>