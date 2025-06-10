
public class SinCos
{

    float tcos[];
    float tsin[];

    public SinCos()
    {
        tcos = new float[360];
        tsin = new float[360];
        int i = 0;
        do
        {
            tcos[i] = (float)Math.cos((double)i * 0.017453292519943295D);
        } while(++i < 360);
        i = 0;
        do
        {
            tsin[i] = (float)Math.sin((double)i * 0.017453292519943295D);
        } while(++i < 360);
    }

    public float getsin(int i)
    {
        for(; i >= 360; i -= 360) { }
        for(; i < 0; i += 360) { }
        return tsin[i];
    }

    public float getcos(int i)
    {
        for(; i >= 360; i -= 360) { }
        for(; i < 0; i += 360) { }
        return tcos[i];
    }
}
