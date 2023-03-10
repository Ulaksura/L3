import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
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
    public int getColumnCount() {
// В данной модели два столбца
        return 4;  // gjvtyzkf c 2 yf 4
    }
    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }
    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step*row;



        Double res= coefficients[coefficients.length - 1] ;
        for(int i=coefficients.length-2;i>=0;i--)
        {
            res = res*x + coefficients[i];
        }
        Double resl= coefficients[0] ;
        for(int i=1;i<coefficients.length;i++)
        {
            resl = resl*x + coefficients[i];
        }



        if (col==0) {
            return x;
        }
        if (col==1) {
            return res;
        }
        if (col==2)
        {
            return resl;
        }
        else {
            return res - resl;
        }
    }
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            case 2:
              return "Столбец 3";
            default:
                return "Столбец 4";
        }
    }
    public Class<?> getColumnClass(int col) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
        return Double.class;
    }
}
