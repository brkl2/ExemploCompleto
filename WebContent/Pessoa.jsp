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
			<tr>
				<td><h:outputLabel value="Nome "></h:outputLabel></td>
				<td><h:inputText value="#{pessoaController.pessoa.nome }"></h:inputText></td>
			</tr>

			<tr>
				<td><h:outputText value="Senha "></h:outputText></td>
				<td><h:inputText
						value="#{pessoaController.pessoa.senha }"></h:inputText></td>
			</tr>

			<tr>
				<td><h:commandButton value="Salvar"
						action="#{pessoaController.salvar }"></h:commandButton></td>
				<td></td>
			</tr>
			<tr>
			<td><h:commandButton value="Entrar"
			         action="#{pessoaController.autenticar }">
			</h:commandButton>
			</td>
		</table>
		

		<h:dataTable value="#{pessoaController.pessoas }" var="p" border="1"
			rendered="#{not empty pessoaController.pessoas}">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome " />
				</f:facet>
				<h:commandLink value="#{p.nome}"
					action="#{pessoaController.autenticar }">
					<f:param name="id" value="#{p.id }" />
				</h:commandLink>
			
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="senha " />
				</f:facet>
				<h:outputLabel value="#{p.senha}"></h:outputLabel>
				
           </h:column>
		</h:dataTable>
	</h:form>
</f:view>
</html>