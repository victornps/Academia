package model;

import java.util.Date;


public class HistoricoExames {
    
    private int id;
    private int alunoId;
    private int exameId;
    private Date data;
    private String faixa;

    public HistoricoExames() {
    }

    public HistoricoExames(int id, int alunoId, int exameId, Date data, String faixa) {
        this.id = id;
        this.alunoId = alunoId;
        this.exameId = exameId;
        this.data = data;
        this.faixa = faixa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getExameId() {
        return exameId;
    }

    public void setExameId(int exameId) {
        this.exameId = exameId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
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
        final HistoricoExames other = (HistoricoExames) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistoricoExames{" + "id=" + id + ", alunoId=" + alunoId + ", exameId=" + exameId + ", data=" + data + ", faixa=" + faixa + '}';
    }
    
    
    
    
}   