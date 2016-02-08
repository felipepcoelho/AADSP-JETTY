package org.aadsp.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.crud.AutenticacaoCRUD;
import org.aadsp.utils.BaseBean;
import org.aadsp.utils.HibernateUtil;

public class IndexBean extends BaseBean
	{
	    public String getLogin()
	    {
	        return login;
	    }

	    public void setLogin(String login)
	    {
	        this.login = login;
	    }

	    public String getSenha()
	    {
	        return senha;
	    }

	    public void setSenha(String senha)
	    {
	        this.senha = senha;
	    }

	    public void autenticar() throws IOException
	    {
	        AutenticacaoCRUD crud = new AutenticacaoCRUD();
	        Autenticacao autenticacao = new Autenticacao();
	        autenticacao.setLogin(login);
	        autenticacao.setSenha(senha);
	        crud.setSession(HibernateUtil.getSessionFactory().openSession());
	        if(crud.autenticar(autenticacao))
	           FacesContext.getCurrentInstance().getExternalContext().redirect("/menuPrincipal/controller.html");
	        else{
	            FacesContext context = FacesContext.getCurrentInstance();
	            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_WARN,"ACESSO NEGADO",  "NÃ£o foi possivel autenticar o usuÃ¡rio com os dados informados") );

	        }
	    }
	    
	    private String login;
	    private String senha;
	}



