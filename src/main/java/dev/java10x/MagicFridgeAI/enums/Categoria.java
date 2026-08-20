package dev.java10x.MagicFridgeAI.enums;

public enum Categoria {
    LATICINIOS("Laticínios"),
    CARNES("Carnes"),
    FRUTAS("Frutas"),
    VERDURAS("Verduras"),
    GRAOS("Grãos"),
    BEBIDAS("Bebidas"),
    CONGELADOS("Congelados"),
    ENLATADOS("Enlatados"),
    TEMPEROS("Temperos"),
    OUTROS("Outros");

    private String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
