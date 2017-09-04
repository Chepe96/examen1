public class Estacionamiento
{
    private int horaEntrada;
    private int minEntrada;
    private int horaSalida;
    private int minSalida;
    private Vehiculo[] estacionamiento;
    
    public Estacionamiento()
    {
        horaEntrada=0;
        minEntrada=0;
        horaSalida=0;
        minSalida=0;
        estacionamiento=new Vehiculo[150];
    }
    
    public void ingresarCoche(Vehiculo unVehiculo,int horaIni,int minIni)
    {
        for(int i=0;i<estacionamiento.length;i++)
        {
            if(estacionamiento[i]==null)
            {
                estacionamiento[i]=unVehiculo;
                horaEntrada=horaIni;
                minEntrada=minIni;
            }
            break;
        }
    }
    
    public String dimeDetalles()
    {
        String cadDetalles="";
        for(int i=0;i<estacionamiento.length;i++)
        {
            if(estacionamiento[i]!=null)
            {
                cadDetalles+="Placas: ";
                cadDetalles+=estacionamiento[i].dimeVehiculo();
                cadDetalles+="Hora entrada: ";
                cadDetalles+=horaEntrada;
            }
        }
        return cadDetalles;
    }
    
    public boolean saleCoche(Vehiculo unVehiculo,int hora2Ini,int min2Ini)
    {
        int existe = this.buscarCoche(unVehiculo.dimeVehiculo());
        if(existe==-1)
        {
            return false;
        }
        horaSalida=hora2Ini;
        minSalida=min2Ini;
        estacionamiento[existe] = null;
        return true;
    }
    
    private int buscarCoche(String placasCoche)
    {
        for(int i=0;i<estacionamiento.length;i++)
        {
            if(estacionamiento[i] != null && estacionamiento[i].dimeVehiculo() == placasCoche)
            {
                return i;
            }
        }
         return -1;
    }
}