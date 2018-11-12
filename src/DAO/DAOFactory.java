package DAO;

public class DAOFactory {
    private static DAOFactory instance = null;
    private static TclientsDAO tclientsDAO = null;
    private static TzakupkaDAO tzakupkaDAO = null;
    private static TsellDAO tsellDAO = null;

    private DAOFactory(){

    }

    public static synchronized DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public TclientsDAO getClientDAO(){
        if (tclientsDAO == null){
            tclientsDAO = new TclientsDAO();
        }
        return tclientsDAO;
    }

    public TzakupkaDAO getZakupkaDAO(){
        if (tzakupkaDAO == null){
            tzakupkaDAO = new TzakupkaDAO();
        }
        return tzakupkaDAO;
    }

    public TsellDAO getSellDAO(){
        if (tsellDAO == null){
            tsellDAO = new TsellDAO();
        }
        return tsellDAO;
    }



}
