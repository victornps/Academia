package model;

import java.util.Date;


public class AgendaExames {
  
    private int id;
    private Date data;
    private String faixas;

    public AgendaExames() {
    }

    public AgendaExames(int id, Date data, String faixas) {
        this.id = id;
        this.data = data;
        this.faixas = faixas;
    }

    public String getFaixas() {
        return faixas;
    }

    public void setFaixas(String faixas) {
        this.faixas = faixas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AgendaExames other = (AgendaExames) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AgendaExames{" + "id=" + id + ", data=" + data + ", faixas=" + faixas + '}';
    }
    
    
    
    
}
