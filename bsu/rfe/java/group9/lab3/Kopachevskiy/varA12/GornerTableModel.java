package bsu.rfe.java.group9.lab3.Kopachevskiy.varA12;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }
    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    //public Boolean getValueet(int row, int col) {
    //}
    @Override
    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        if (col == 0) {
            return x;
        } else if (col == 1) {
            Double result = coefficients[0] * x + coefficients[1];
            for (int i = 2; i < coefficients.length; i++) {
                result += result * x + coefficients[i];
            }
            return result;
        } else {
            double x1 = from + step * row;
            double result = coefficients[0] * x1 + coefficients[1];
            for (int i = 2; i < coefficients.length; i++) {
                result += result * x1 + coefficients[i];
            }
            if ((int)result != 0)
                return false;
            else
                return true;
        }
    }
    @Override
    public Class<?> getColumnClass(int col) {
        if (col != 2) {
            return Double.class;
        }
        else {
            return Boolean.class;
        }
    }
    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0: return "Значение х";
            case 1: return "Значение многочлена";
            case 2: return "Малое число?";
        }
        return "";
    }
}