package com.example.dp;

public class Model
{
    public static int difficulty;
    public static int difficulty1;
    int data;
    int row;
    int column;

    public Model(int data, int row, int column) {
        this.data = data;
        this.row = row;
        this.column = column;
    }

    public Model() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
