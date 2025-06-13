import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CarDefine implements Runnable {
   Trackers t;
   GameSparker gs;
   ContO[] bco;
   Medium m;
   Thread carloader;
   Thread actionloader;
   Thread stageaction;
   int[][] swits = new int[][]{
      {50, 185, 282},
      {100, 200, 310},
      {60, 180, 275},
      {76, 195, 298},
      {70, 170, 275},
      {70, 202, 293},
      {60, 170, 289},
      {70, 206, 291},
      {90, 210, 295},
      {90, 190, 276},
      {70, 200, 295},
      {50, 160, 270},
      {90, 200, 305},
      {50, 130, 210},
      {80, 200, 300},
      {70, 210, 290},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0},
      {0, 0, 0}
   };
   float[][] acelf = new float[][]{
      {11.0F, 5.0F, 3.0F},
      {14.0F, 7.0F, 5.0F},
      {10.0F, 5.0F, 3.5F},
      {11.0F, 6.0F, 3.5F},
      {10.0F, 5.0F, 3.5F},
      {12.0F, 6.0F, 3.0F},
      {7.0F, 9.0F, 4.0F},
      {11.0F, 5.0F, 3.0F},
      {12.0F, 7.0F, 4.0F},
      {12.0F, 7.0F, 3.5F},
      {11.5F, 6.5F, 3.5F},
      {9.0F, 5.0F, 3.0F},
      {13.0F, 7.0F, 4.5F},
      {7.5F, 3.5F, 3.0F},
      {11.0F, 7.5F, 4.0F},
      {12.0F, 6.0F, 3.5F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F},
      {0.0F, 0.0F, 0.0F}
   };
   int[] handb = new int[]{
      7,
      10,
      7,
      15,
      12,
      8,
      9,
      10,
      5,
      7,
      8,
      10,
      8,
      12,
      7,
      7,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   float[] airs = new float[]{
      1.0F,
      1.2F,
      0.95F,
      1.0F,
      2.2F,
      1.0F,
      0.9F,
      0.8F,
      1.0F,
      0.9F,
      1.15F,
      0.8F,
      1.0F,
      0.3F,
      1.3F,
      1.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   int[] airc = new int[]{
      70,
      30,
      40,
      40,
      30,
      50,
      40,
      90,
      40,
      50,
      75,
      10,
      50,
      0,
      100,
      60,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] turn = new int[]{
      6,
      9,
      5,
      7,
      8,
      7,
      5,
      5,
      9,
      7,
      7,
      4,
      6,
      5,
      7,
      6,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   float[] grip = new float[]{
      20.0F,
      27.0F,
      18.0F,
      22.0F,
      19.0F,
      20.0F,
      25.0F,
      20.0F,
      19.0F,
      24.0F,
      22.5F,
      25.0F,
      30.0F,
      27.0F,
      25.0F,
      27.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   float[] bounce = new float[]{
      1.2F,
      1.05F,
      1.3F,
      1.15F,
      1.3F,
      1.2F,
      1.15F,
      1.1F,
      1.2F,
      1.1F,
      1.15F,
      0.8F,
      1.05F,
      0.8F,
      1.1F,
      1.15F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   float[] simag = new float[]{
      0.9F,
      0.85F,
      1.05F,
      0.9F,
      0.85F,
      0.9F,
      1.05F,
      0.9F,
      1.0F,
      1.05F,
      0.9F,
      1.1F,
      0.9F,
      1.3F,
      0.9F,
      1.15F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   float[] moment = new float[]{
      1.3F,
      0.75F,
      1.4F,
      1.2F,
      1.1F,
      1.38F,
      1.43F,
      1.48F,
      1.35F,
      1.7F,
      1.42F,
      2.0F,
      1.26F,
      3.0F,
      1.5F,
      2.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   float[] comprad = new float[]{
      0.5F,
      0.4F,
      0.8F,
      0.5F,
      0.4F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.8F,
      0.5F,
      1.5F,
      0.5F,
      0.8F,
      0.5F,
      0.8F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   int[] push = new int[]{
      2,
      2,
      3,
      3,
      2,
      2,
      2,
      4,
      2,
      2,
      2,
      4,
      2,
      2,
      2,
      2,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] revpush = new int[]{
      2,
      3,
      2,
      2,
      2,
      2,
      2,
      1,
      2,
      1,
      2,
      1,
      2,
      2,
      2,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] lift = new int[]{
      0,
      30,
      0,
      20,
      0,
      30,
      0,
      0,
      20,
      0,
      0,
      0,
      10,
      0,
      30,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] revlift = new int[]{
      0,
      0,
      15,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      32,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] powerloss = new int[]{
      2500000,
      2500000,
      3500000,
      2500000,
      4000000,
      2500000,
      3200000,
      3200000,
      2750000,
      5500000,
      2750000,
      4500000,
      3500000,
      16700000,
      3000000,
      5500000,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] flipy = new int[]{
      -50,
      -60,
      -92,
      -44,
      -60,
      -57,
      -54,
      -60,
      -77,
      -57,
      -82,
      -85,
      -28,
      -100,
      -63,
      -127,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] msquash = new int[]{
      7,
      4,
      7,
      2,
      8,
      4,
      6,
      4,
      3,
      8,
      4,
      10,
      3,
      20,
      3,
      8,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int[] clrad = new int[]{
      3300,
      1700,
      4700,
      3000,
      2000,
      4500,
      3500,
      5000,
      10000,
      15000,
      4000,
      7000,
      10000,
      15000,
      5500,
      5000,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   float[] dammult = new float[]{
      0.75F,
      0.8F,
      0.45F,
      0.8F,
      0.42F,
      0.7F,
      0.72F,
      0.6F,
      0.58F,
      0.41F,
      0.67F,
      0.45F,
      0.61F,
      0.25F,
      0.38F,
      0.52F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   int[] maxmag = new int[]{
      7600,
      4200,
      7200,
      6000,
      6000,
      15000,
      17200,
      17000,
      18000,
      11000,
      19000,
      10700,
      13000,
      45000,
      5800,
      18000,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   float[] dishandle = new float[]{
      0.65F,
      0.6F,
      0.55F,
      0.77F,
      0.62F,
      0.9F,
      0.6F,
      0.72F,
      0.45F,
      0.8F,
      0.95F,
      0.4F,
      0.87F,
      0.42F,
      1.0F,
      0.95F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   float[] outdam = new float[]{
      0.68F,
      0.35F,
      0.8F,
      0.5F,
      0.42F,
      0.76F,
      0.82F,
      0.76F,
      0.72F,
      0.62F,
      0.79F,
      0.95F,
      0.77F,
      1.0F,
      0.85F,
      1.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F,
      0.0F
   };
   int[] cclass = new int[]{
      0,
      0,
      0,
      0,
      0,
      1,
      2,
      2,
      2,
      2,
      3,
      4,
      4,
      4,
      4,
      4,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   String[] names = new String[]{
      "Tornado Shark",
      "Formula 7",
      "Wow Caninaro",
      "La Vita Crab",
      "Nimi",
      "MAX Revenge",
      "Lead Oxide",
      "Kool Kat",
      "Drifter X",
      "Sword of Justice",
      "High Rider",
      "EL KING",
      "Mighty Eight",
      "M A S H E E N",
      "Radical One",
      "DR Monstaa",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      ""
   };
   int[] enginsignature = new int[]{
      0,
      1,
      2,
      1,
      0,
      3,
      2,
      2,
      1,
      0,
      3,
      4,
      1,
      4,
      0,
      3,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   int lastload = 0;
   int nlcars = 0;
   int nlocars = 0;
   int xnlocars = 0;
   boolean[] include = new boolean[40];
   String[] createdby = new String[40];
   int[] publish = new int[40];
   String[] loadnames = new String[20];
   int nl = 0;
   int action = 0;
   boolean carlon = false;
   int reco = -2;
   int[] lcardate = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   int haltload = 0;
   int onloadingcar = 0;
   int ac = -1;
   String acname = "Radical One";
   String fails = "";
   String tnickey = "";
   String tclan = "";
   String tclankey = "";
   int loadlist = 0;
   int[] adds = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   String viewname = "";
   int staction = 0;
   String onstage = "";
   int inslot = -1;
   int roundslot = 0;
   String lastcar = "";
   int msloaded = 0;
   int[] top20adds = new int[20];

   public CarDefine(ContO[] var1, Medium var2, Trackers var3, GameSparker var4) {
      this.bco = var1;
      this.m = var2;
      this.t = var3;
      this.gs = var4;
   }

   public void loadstat(byte[] var1, String var2, int var3, int var4, int var5, int var6) {
      this.names[var6] = var2;
      boolean var7 = false;
      boolean var8 = false;
      String var9 = "";
      int[] var10 = new int[]{128, 128, 128, 128, 128};
      int var11 = 640;
      int[] var12 = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
      int[] var13 = new int[]{50, 50, 50};
      this.enginsignature[var6] = 0;
      float var14 = 0.0F;
      this.publish[var6 - 16] = 0;
      this.createdby[var6 - 16] = "Unkown User";

      try {
         DataInputStream var15 = new DataInputStream(new ByteArrayInputStream(var1));

         while ((var9 = var15.readLine()) != null) {
            var9 = var9.trim();
            if (var9.startsWith("stat(")) {
               try {
                  var11 = 0;

                  for (int var16 = 0; var16 < 5; var16++) {
                     var10[var16] = this.getvalue("stat", var9, var16);
                     if (var10[var16] > 200) {
                        var10[var16] = 200;
                     }

                     if (var10[var16] < 16) {
                        var10[var16] = 16;
                     }

                     var11 += var10[var16];
                  }

                  var7 = true;
               } catch (Exception var22) {
                  var7 = false;
               }
            }

            if (var9.startsWith("physics(")) {
               try {
                  for (int var29 = 0; var29 < 11; var29++) {
                     var12[var29] = this.getvalue("physics", var9, var29);
                     if (var12[var29] > 100) {
                        var12[var29] = 100;
                     }

                     if (var12[var29] < 0) {
                        var12[var29] = 0;
                     }
                  }

                  for (int var30 = 0; var30 < 3; var30++) {
                     var13[var30] = this.getvalue("physics", var9, var30 + 11);
                     if (var30 != 0 && var13[var30] > 100) {
                        var13[var30] = 100;
                     }

                     if (var13[var30] < 0) {
                        var13[var30] = 0;
                     }
                  }

                  this.enginsignature[var6] = this.getvalue("physics", var9, 14);
                  if (this.enginsignature[var6] > 4) {
                     this.enginsignature[var6] = 0;
                  }

                  if (this.enginsignature[var6] < 0) {
                     this.enginsignature[var6] = 0;
                  }

                  var14 = this.getvalue("physics", var9, 15);
                  if (var14 > 0.0F) {
                     var8 = true;
                  }
               } catch (Exception var23) {
                  var8 = false;
               }
            }

            if (var9.startsWith("handling(")) {
               try {
                  int var31 = this.getvalue("handling", var9, 0);
                  if (var31 > 200) {
                     var31 = 200;
                  }

                  if (var31 < 50) {
                     var31 = 50;
                  }

                  this.dishandle[var6] = var31 / 200.0F;
               } catch (Exception var21) {
               }
            }

            if (var9.startsWith("carmaker(")) {
               this.createdby[var6 - 16] = this.getSvalue("carmaker", var9, 0);
            }

            if (var9.startsWith("publish(")) {
               this.publish[var6 - 16] = this.getvalue("publish", var9, 0);
            }
         }

         var15.close();
      } catch (Exception var24) {
         System.out.println("Error Loading Car Stat: " + var24);
      }

      if (var7 && var8) {
         int var28 = 0;
         if (var11 > 680) {
            var28 = 680 - var11;
         }

         if (var11 > 640 && var11 < 680) {
            var28 = 640 - var11;
         }

         if (var11 > 600 && var11 < 640) {
            var28 = 600 - var11;
         }

         if (var11 > 560 && var11 < 600) {
            var28 = 560 - var11;
         }

         if (var11 > 520 && var11 < 560) {
            var28 = 520 - var11;
         }

         if (var11 < 520) {
            var28 = 520 - var11;
         }

         while (var28 != 0) {
            for (int var32 = 0; var32 < 5; var32++) {
               if (var28 > 0 && var10[var32] < 200) {
                  var10[var32]++;
                  var28--;
               }

               if (var28 < 0 && var10[var32] > 16) {
                  var10[var32]--;
                  var28++;
               }
            }
         }

         var11 = 0;

         for (int var33 = 0; var33 < 5; var33++) {
            var11 += var10[var33];
         }

         if (var11 == 520) {
            this.cclass[var6] = 0;
         }

         if (var11 == 560) {
            this.cclass[var6] = 1;
         }

         if (var11 == 600) {
            this.cclass[var6] = 2;
         }

         if (var11 == 640) {
            this.cclass[var6] = 3;
         }

         if (var11 == 680) {
            this.cclass[var6] = 4;
         }

         byte var34 = 0;
         byte var17 = 0;
         float var18 = 0.5F;
         if (var10[0] == 200) {
            var34 = 1;
            var17 = 1;
         }

         if (var10[0] > 192 && var10[0] < 200) {
            var34 = 12;
            var17 = 1;
            var18 = (var10[0] - 192) / 8.0F;
         }

         if (var10[0] == 192) {
            var34 = 12;
            var17 = 12;
         }

         if (var10[0] > 148 && var10[0] < 192) {
            var34 = 14;
            var17 = 12;
            var18 = (var10[0] - 148) / 44.0F;
         }

         if (var10[0] == 148) {
            var34 = 14;
            var17 = 14;
         }

         if (var10[0] > 133 && var10[0] < 148) {
            var34 = 10;
            var17 = 14;
            var18 = (var10[0] - 133) / 15.0F;
         }

         if (var10[0] == 133) {
            var34 = 10;
            var17 = 10;
         }

         if (var10[0] > 112 && var10[0] < 133) {
            var34 = 15;
            var17 = 10;
            var18 = (var10[0] - 112) / 21.0F;
         }

         if (var10[0] == 112) {
            var34 = 15;
            var17 = 15;
         }

         if (var10[0] > 107 && var10[0] < 112) {
            var34 = 11;
            var17 = 15;
            var18 = (var10[0] - 107) / 5.0F;
         }

         if (var10[0] == 107) {
            var34 = 11;
            var17 = 11;
         }

         if (var10[0] > 88 && var10[0] < 107) {
            var34 = 13;
            var17 = 11;
            var18 = (var10[0] - 88) / 19.0F;
         }

         if (var10[0] == 88) {
            var34 = 13;
            var17 = 13;
         }

         if (var10[0] > 88) {
            this.swits[var6][0] = (int)((this.swits[var17][0] - this.swits[var34][0]) * var18 + this.swits[var34][0]);
            this.swits[var6][1] = (int)((this.swits[var17][1] - this.swits[var34][1]) * var18 + this.swits[var34][1]);
            this.swits[var6][2] = (int)((this.swits[var17][2] - this.swits[var34][2]) * var18 + this.swits[var34][2]);
         } else {
            var18 = var10[0] / 88.0F;
            if (var18 < 0.76) {
               var18 = 0.76F;
            }

            this.swits[var6][0] = (int)(50.0F * var18);
            this.swits[var6][1] = (int)(130.0F * var18);
            this.swits[var6][2] = (int)(210.0F * var18);
         }

         var34 = 0;
         var17 = 0;
         var18 = 0.5F;
         if (var10[1] == 200) {
            var34 = 1;
            var17 = 1;
         }

         if (var10[1] > 150 && var10[1] < 200) {
            var34 = 14;
            var17 = 1;
            var18 = (var10[1] - 150) / 50.0F;
         }

         if (var10[1] == 150) {
            var34 = 14;
            var17 = 14;
         }

         if (var10[1] > 144 && var10[1] < 150) {
            var34 = 9;
            var17 = 14;
            var18 = (var10[1] - 144) / 6.0F;
         }

         if (var10[1] == 144) {
            var34 = 9;
            var17 = 9;
         }

         if (var10[1] > 139 && var10[1] < 144) {
            var34 = 6;
            var17 = 9;
            var18 = (var10[1] - 139) / 5.0F;
         }

         if (var10[1] == 139) {
            var34 = 6;
            var17 = 6;
         }

         if (var10[1] > 128 && var10[1] < 139) {
            var34 = 15;
            var17 = 6;
            var18 = (var10[1] - 128) / 11.0F;
         }

         if (var10[1] == 128) {
            var34 = 15;
            var17 = 15;
         }

         if (var10[1] > 122 && var10[1] < 128) {
            var34 = 10;
            var17 = 15;
            var18 = (var10[1] - 122) / 6.0F;
         }

         if (var10[1] == 122) {
            var34 = 10;
            var17 = 10;
         }

         if (var10[1] > 119 && var10[1] < 122) {
            var34 = 3;
            var17 = 10;
            var18 = (var10[1] - 119) / 3.0F;
         }

         if (var10[1] == 119) {
            var34 = 3;
            var17 = 3;
         }

         if (var10[1] > 98 && var10[1] < 119) {
            var34 = 5;
            var17 = 3;
            var18 = (var10[1] - 98) / 21.0F;
         }

         if (var10[1] == 98) {
            var34 = 5;
            var17 = 5;
         }

         if (var10[1] > 81 && var10[1] < 98) {
            var34 = 0;
            var17 = 5;
            var18 = (var10[1] - 81) / 17.0F;
         }

         if (var10[1] == 81) {
            var34 = 0;
            var17 = 0;
         }

         if (var10[1] <= 80) {
            var34 = 2;
            var17 = 2;
         }

         if (var10[0] <= 88) {
            var34 = 13;
            var17 = 13;
         }

         this.acelf[var6][0] = (this.acelf[var17][0] - this.acelf[var34][0]) * var18 + this.acelf[var34][0];
         this.acelf[var6][1] = (this.acelf[var17][1] - this.acelf[var34][1]) * var18 + this.acelf[var34][1];
         this.acelf[var6][2] = (this.acelf[var17][2] - this.acelf[var34][2]) * var18 + this.acelf[var34][2];
         if (var10[1] <= 70 && var10[0] > 88) {
            this.acelf[var6][0] = 9.0F;
            this.acelf[var6][1] = 4.0F;
            this.acelf[var6][2] = 3.0F;
         }

         var18 = (var10[2] - 88) / 109.0F;
         if (var18 > 1.0F) {
            var18 = 1.0F;
         }

         if (var18 < -0.55) {
            var18 = -0.55F;
         }

         this.airs[var6] = 0.55F + 0.45F * var18 + 0.4F * (var12[9] / 100.0F);
         if (this.airs[var6] < 0.3) {
            this.airs[var6] = 0.3F;
         }

         this.airc[var6] = (int)(10.0F + 70.0F * var18 + 30.0F * (var12[10] / 100.0F));
         if (this.airc[var6] < 0) {
            this.airc[var6] = 0;
         }

         int var19 = (int)(670.0F - (var12[9] + var12[10]) / 200.0F * 420.0F);
         if (var10[0] <= 88) {
            var19 = (int)(1670.0F - (var12[9] + var12[10]) / 200.0F * 1420.0F);
         }

         if (var10[2] > 190 && var19 < 300) {
            var19 = 300;
         }

         this.powerloss[var6] = var19 * 10000;
         this.moment[var6] = 0.7F + (var10[3] - 16) / 184.0F * 1.0F;
         if (var10[0] < 110) {
            this.moment[var6] = 0.75F + (var10[3] - 16) / 184.0F * 1.25F;
         }

         if (var10[3] == 200 && var10[4] == 200 && var10[0] <= 88) {
            this.moment[var6] = 3.0F;
         }

         float var20 = 0.9F + (var10[4] - 90) * 0.01F;
         if (var20 < 0.6) {
            var20 = 0.6F;
         }

         if (var10[4] == 200 && var10[0] <= 88) {
            var20 = 3.0F;
         }

         this.maxmag[var6] = (int)(var14 * var20);
         this.outdam[var6] = 0.35F + (var20 - 0.6F) * 0.5F;
         if (this.outdam[var6] < 0.35) {
            this.outdam[var6] = 0.35F;
         }

         if (this.outdam[var6] > 1.0F) {
            this.outdam[var6] = 1.0F;
         }

         this.clrad[var6] = (int)(var13[0] * var13[0] * 1.5);
         if (this.clrad[var6] < 1000) {
            this.clrad[var6] = 1000;
         }

         this.dammult[var6] = 0.3F + var13[1] * 0.005F;
         this.msquash[var6] = (int)(2.0 + var13[2] / 7.6);
         this.flipy[var6] = var4;
         this.handb[var6] = (int)(7.0F + var12[0] / 100.0F * 8.0F);
         this.turn[var6] = (int)(4.0F + var12[1] / 100.0F * 6.0F);
         this.grip[var6] = 16.0F + var12[2] / 100.0F * 14.0F;
         if (this.grip[var6] < 21.0F) {
            this.swits[var6][0] = (int)(this.swits[var6][0] + 40.0F * ((21.0F - this.grip[var6]) / 5.0F));
            if (this.swits[var6][0] > 100) {
               this.swits[var6][0] = 100;
            }
         }

         this.bounce[var6] = 0.8F + var12[3] / 100.0F * 0.6F;
         if (var12[3] > 67) {
            this.airs[var6] = this.airs[var6] * (0.76F + (1.0F - var12[3] / 100.0F) * 0.24F);
            this.airc[var6] = (int)(this.airc[var6] * (0.76F + (1.0F - var12[3] / 100.0F) * 0.24F));
         }

         this.lift[var6] = (int)((float)var12[5] * var12[5] / 10000.0F * 30.0F);
         this.revlift[var6] = (int)(var12[6] / 100.0F * 32.0F);
         this.push[var6] = (int)(2.0F + var12[7] / 100.0F * 2.0F * ((30 - this.lift[var6]) / 30));
         this.revpush[var6] = (int)(1.0F + var12[8] / 100.0F * 2.0F);
         this.comprad[var6] = var3 / 400.0F + (var10[3] - 16) / 184.0F * 0.2F;
         if (this.comprad[var6] < 0.4) {
            this.comprad[var6] = 0.4F;
         }

         this.simag[var6] = (var5 - 17) * 0.0167F + 0.85F;
      } else {
         this.names[var6] = "";
      }
   }

   public int getvalue(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return Float.valueOf(var7).intValue();
   }

   public String getSvalue(String var1, String var2, int var3) {
      String var4 = "";
      int var5 = 0;

      for (int var6 = var1.length() + 1; var6 < var2.length() && var5 <= var3; var6++) {
         String var7 = "" + var2.charAt(var6);
         if (var7.equals(",") || var7.equals(")")) {
            var5++;
         } else if (var5 == var3) {
            var4 = var4 + var7;
         }
      }

      return var4;
   }

   public int servervalue(String var1, int var2) {
      int var3 = -1;

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("|")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         if (var8.equals("")) {
            var8 = "-1";
         }

         var3 = Integer.valueOf(var8);
      } catch (Exception var9) {
      }

      return var3;
   }

   public String serverSvalue(String var1, int var2) {
      String var3 = "";

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("|")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         var3 = var8;
      } catch (Exception var9) {
      }

      return var3;
   }

   public void loadready() {
      this.m.csky[0] = 170;
      this.m.csky[1] = 220;
      this.m.csky[2] = 255;
      this.m.cfade[0] = 255;
      this.m.cfade[1] = 220;
      this.m.cfade[2] = 220;
      this.m.snap[0] = 0;
      this.m.snap[1] = 0;
      this.m.snap[2] = 0;
      this.fails = "";

      for (int var1 = 0; var1 < 20; var1++) {
         this.loadnames[var1] = "";
      }

      this.nl = 0;
      this.action = 0;
   }

   public void sparkactionloader() {
      this.actionloader = new Thread(this);
      this.actionloader.start();
   }

   public void sparkcarloader() {
      if (!this.carlon) {
         this.carloader = new Thread(this);
         this.carloader.start();
         this.carlon = true;
      }
   }

   public void sparkstageaction() {
      this.stageaction = new Thread(this);
      this.stageaction.start();
   }

   public void stopallnow() {
      this.staction = 0;
      this.action = 0;
      if (this.carloader != null) {
         this.carloader.stop();
         this.carloader = null;
      }

      if (this.actionloader != null) {
         this.actionloader.stop();
         this.actionloader = null;
      }

      if (this.stageaction != null) {
         this.stageaction.stop();
         this.stageaction = null;
      }
   }

   @Override
   public void run() {
      if (Thread.currentThread() == this.actionloader) {
         if (this.action == 10) {
            int var1 = -1;

            try {
               Socket var2 = new Socket("69.195.146.194", 7061);
               BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.getInputStream()));
               PrintWriter var4 = new PrintWriter(var2.getOutputStream(), true);
               var4.println("9|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.names[this.ac] + "|");
               String var5 = var3.readLine();
               if (var5 != null) {
                  var1 = this.servervalue(var5, 0);
               }

               var2.close();
               var3.close();
               var4.close();
            } catch (Exception var11) {
               var1 = -1;
            }

            if (var1 == 0) {
               this.action = 3;
            } else {
               this.action = -10;
            }

            System.gc();
         }

         if (this.action == 1) {
            this.reco = -1;

            try {
               Socket var17 = new Socket("69.195.146.194", 7061);
               BufferedReader var34 = new BufferedReader(new InputStreamReader(var17.getInputStream()));
               PrintWriter var47 = new PrintWriter(var17.getOutputStream(), true);
               var47.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
               String var59 = var34.readLine();
               if (var59 != null) {
                  this.reco = this.servervalue(var59, 0);
                  if (this.reco == 0 || this.reco == 3 || this.reco > 10) {
                     this.tnickey = this.serverSvalue(var59, 1);
                     if (this.reco != -167) {
                        this.tclan = this.serverSvalue(var59, 2);
                        this.tclankey = this.serverSvalue(var59, 3);
                     } else {
                        this.tclan = "";
                        this.tclankey = "";
                     }
                  }
               }

               var17.close();
               var34.close();
               var47.close();
            } catch (Exception var16) {
               this.reco = -1;
            }

            if (this.reco != 0 && this.reco != 3 && this.reco <= 10) {
               this.action = 0;
            } else {
               this.action = 2;
            }

            System.gc();
         }

         while (this.action == 2) {
         }

         if (this.action == 3) {
            String[] var18 = new String[700];
            this.nl = 0;
            String var35 = "";

            try {
               URL var48 = new URL(
                  Madness.corsProxy + "http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
               );
               DataInputStream var61 = new DataInputStream(var48.openStream());

               while ((var35 = var61.readLine()) != null) {
                  var35 = "" + var35.trim();
                  if (var35.startsWith("mycars")) {
                     boolean var69 = true;

                     while (var69 && this.nl < 700) {
                        var18[this.nl] = this.getSvalue("mycars", var35, this.nl);
                        if (var18[this.nl].equals("")) {
                           var69 = false;
                        } else {
                           this.nl++;
                        }
                     }
                  }
               }

               if (this.nl > 0) {
                  this.action = 4;
               } else {
                  this.action = -1;
               }

               var61.close();
            } catch (Exception var15) {
               String var60 = "" + var15;
               if (var60.indexOf("FileNotFound") != -1) {
                  this.action = -1;
               } else {
                  this.action = -2;
               }
            }

            if (this.action == 4) {
               this.gs.mcars.hide();
               this.gs.mcars.removeAll();

               for (int var49 = 0; var49 < this.nl; var49++) {
                  this.gs.mcars.add(this.gs.rd, var18[var49]);
               }

               if (this.lastcar.equals("")) {
                  this.gs.mcars.select(0);
               } else {
                  this.gs.mcars.select(this.lastcar);
                  this.lastcar = "";
               }

               for (int var50 = 0; var50 < 40; var50++) {
                  this.include[var50] = false;
               }

               this.roundslot = 16;
               this.nlocars = 16;
            }
         }

         if (this.action == 4) {
            this.m.csky[0] = 170;
            this.m.csky[1] = 220;
            this.m.csky[2] = 255;
            this.m.cfade[0] = 255;
            this.m.cfade[1] = 220;
            this.m.cfade[2] = 220;
            this.m.snap[0] = 0;
            this.m.snap[1] = 0;
            this.m.snap[2] = 0;
            if (this.loadonlinecar(this.gs.mcars.getSelectedItem(), this.roundslot) == this.roundslot) {
               this.inslot = this.roundslot++;
               if (this.roundslot == 36) {
                  this.roundslot = 16;
               }

               if (this.nlocars < 36) {
                  this.nlocars++;
               }

               this.lastload = 2;
               this.action = 5;
            } else {
               if (this.lastload == 2) {
                  this.lastload = 0;
               }

               this.action = -1;
            }

            System.gc();
         }

         if (this.action == 6) {
            int var19 = -1;

            try {
               if (this.ac != -1) {
                  this.acname = this.names[this.ac];
               }

               Socket var38 = new Socket("69.195.146.194", 7061);
               BufferedReader var51 = new BufferedReader(new InputStreamReader(var38.getInputStream()));
               PrintWriter var62 = new PrintWriter(var38.getOutputStream(), true);
               var62.println("8|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.acname + "|");
               String var70 = var51.readLine();
               if (var70 != null) {
                  var19 = this.servervalue(var70, 0);
               }

               var38.close();
               var51.close();
               var62.close();
            } catch (Exception var10) {
               var19 = -1;
            }

            if (var19 == 0) {
               if (this.lastload == 2) {
                  this.lastload = -2;
                  this.lastcar = this.gs.mcars.getSelectedItem();
               }

               this.action = 7;
            }

            if (var19 == 3) {
               this.action = -7;
            }

            if (var19 == 4) {
               this.action = -8;
            }

            if (this.action == 6) {
               this.action = -9;
            }

            System.gc();
         }

         if (this.action == 11) {
            this.nl = 0;
            String var20 = "";

            try {
               String var39 = "all";
               if (this.loadlist == 1) {
                  var39 = "Wall";
               }

               if (this.loadlist == 2) {
                  var39 = "WA";
               }

               if (this.loadlist == 3) {
                  var39 = "WAB";
               }

               if (this.loadlist == 4) {
                  var39 = "WB";
               }

               if (this.loadlist == 5) {
                  var39 = "WBC";
               }

               if (this.loadlist == 6) {
                  var39 = "WC";
               }

               if (this.loadlist == 7) {
                  var39 = "Mall";
               }

               if (this.loadlist == 8) {
                  var39 = "MA";
               }

               if (this.loadlist == 9) {
                  var39 = "MAB";
               }

               if (this.loadlist == 10) {
                  var39 = "MB";
               }

               if (this.loadlist == 11) {
                  var39 = "MBC";
               }

               if (this.loadlist == 12) {
                  var39 = "MC";
               }

               if (this.loadlist == 13) {
                  var39 = "Sall";
               }

               if (this.loadlist == 14) {
                  var39 = "SA";
               }

               if (this.loadlist == 15) {
                  var39 = "SAB";
               }

               if (this.loadlist == 16) {
                  var39 = "SB";
               }

               if (this.loadlist == 17) {
                  var39 = "SBC";
               }

               if (this.loadlist == 18) {
                  var39 = "SC";
               }

               if (this.loadlist == 19) {
                  var39 = "Aall";
               }

               if (this.loadlist == 20) {
                  var39 = "AA";
               }

               if (this.loadlist == 21) {
                  var39 = "AAB";
               }

               if (this.loadlist == 22) {
                  var39 = "AB";
               }

               if (this.loadlist == 23) {
                  var39 = "ABC";
               }

               if (this.loadlist == 24) {
                  var39 = "AC";
               }

               URL var52 = new URL(Madness.corsProxy + "http://multiplayer.needformadness.com/cars/top20/" + var39 + ".txt");
               DataInputStream var63 = new DataInputStream(var52.openStream());

               while ((var20 = var63.readLine()) != null) {
                  var20 = "" + var20.trim();
                  if (var20.startsWith("cars")) {
                     boolean var71 = true;

                     while (var71 && this.nl < 20) {
                        this.loadnames[this.nl] = this.getSvalue("cars", var20, this.nl);
                        if (this.loadnames[this.nl].equals("")) {
                           var71 = false;
                        } else {
                           this.nl++;
                        }
                     }
                  }

                  if (var20.startsWith("adds")) {
                     for (int var72 = 0; var72 < this.nl; var72++) {
                        this.adds[var72] = this.getvalue("adds", var20, var72);
                     }
                  }
               }

               if (this.nl > 0) {
                  this.action = 12;
               } else {
                  this.action = -1;
               }

               var63.close();
            } catch (Exception var14) {
               this.action = -1;
            }

            System.gc();
         }

         if (this.action == 12) {
            this.m.csky[0] = 170;
            this.m.csky[1] = 220;
            this.m.csky[2] = 255;
            this.m.cfade[0] = 255;
            this.m.cfade[1] = 220;
            this.m.cfade[2] = 220;
            this.m.snap[0] = 0;
            this.m.snap[1] = 0;
            this.m.snap[2] = 0;
            this.xnlocars = 36;
            int var23 = this.nl;

            for (this.nl = 0; this.nl < var23; this.nl++) {
               if (this.xnlocars < 56 && this.loadonlinecar(this.loadnames[this.nl], this.xnlocars) == this.xnlocars) {
                  this.xnlocars++;
               }
            }

            this.nl = 0;
            if (this.xnlocars > 36) {
               this.action = 13;
            } else {
               this.action = -1;
            }

            System.gc();
         }

         if (this.action == 101) {
            this.nl = 0;
            String var24 = "";

            try {
               URL var40 = new URL(Madness.corsProxy + "http://multiplayer.needformadness.com/cars/lists/" + this.viewname + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "");
               DataInputStream var54 = new DataInputStream(var40.openStream());

               while ((var24 = var54.readLine()) != null) {
                  var24 = "" + var24.trim();
                  if (var24.startsWith("mycars")) {
                     boolean var64 = true;

                     while (var64 && this.nl < 20) {
                        this.loadnames[this.nl] = this.getSvalue("mycars", var24, this.nl);
                        if (this.loadnames[this.nl].equals("")) {
                           var64 = false;
                        } else {
                           this.nl++;
                        }
                     }
                  }
               }

               if (this.nl > 0) {
                  this.action = 102;
               } else {
                  this.action = -2;
               }

               var54.close();
            } catch (Exception var13) {
               String var53 = "" + var13;
               if (var53.indexOf("FileNotFound") != -1) {
                  this.action = -2;
               } else {
                  this.action = -1;
               }
            }

            System.gc();
         }

         if (this.action == 102) {
            this.m.csky[0] = 170;
            this.m.csky[1] = 220;
            this.m.csky[2] = 255;
            this.m.cfade[0] = 255;
            this.m.cfade[1] = 220;
            this.m.cfade[2] = 220;
            this.m.snap[0] = 0;
            this.m.snap[1] = 0;
            this.m.snap[2] = 0;

            for (int var27 = 0; var27 < 40; var27++) {
               this.include[var27] = false;
            }

            this.xnlocars = 36;
            int var28 = this.nl;

            for (this.nl = 0; this.nl < var28; this.nl++) {
               if (this.xnlocars < 56 && this.loadonlinecar(this.loadnames[this.nl], this.xnlocars) == this.xnlocars) {
                  this.xnlocars++;
               }
            }

            this.nl = 0;
            if (this.xnlocars > 36) {
               this.action = 103;
            } else {
               this.action = -1;
            }

            System.gc();
         }

         this.actionloader = null;
      }

      if (Thread.currentThread() == this.carloader) {
         while (this.nl > 0) {
            int var29 = 0;

            for (int var41 = 16; var41 < 56; var41++) {
               if (this.loadnames[this.nl - 1].equals(this.names[var41])) {
                  var29 = -1;
               }
            }

            if (this.fails.indexOf("|" + this.loadnames[this.nl - 1] + "|") != -1) {
               var29 = -1;
            }

            if (var29 != -1) {
               int var42 = this.lcardate[0];
               int var55 = 36;
               if (this.haltload > 0) {
                  var55 = 36 + this.haltload;
                  var42 = this.lcardate[this.haltload];
               }

               var29 = var55;

               for (int var65 = var55; var65 < 56; var65++) {
                  if (this.lcardate[var65 - 36] < var42) {
                     var42 = this.lcardate[var65 - 36];
                     var29 = var65;
                  }
               }

               this.onloadingcar = var29 - 35;
               if (this.loadonlinecar(this.loadnames[this.nl - 1], var29) == -1) {
                  this.fails = this.fails + "|" + this.loadnames[this.nl - 1] + "|";
               } else {
                  this.lcardate[var29 - 36]++;
               }

               this.onloadingcar = 0;
            }

            this.nl--;

            try {
               Thread.sleep(20L);
            } catch (InterruptedException var9) {
            }
         }

         this.carlon = false;
         this.carloader = null;
      }

      if (Thread.currentThread() == this.stageaction) {
         if (this.staction == 1) {
            int var31 = -1;

            try {
               Socket var43 = new Socket("69.195.146.194", 7061);
               BufferedReader var56 = new BufferedReader(new InputStreamReader(var43.getInputStream()));
               PrintWriter var66 = new PrintWriter(var43.getOutputStream(), true);
               var66.println("19|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.onstage + "|");
               String var73 = var56.readLine();
               if (var73 != null) {
                  var31 = this.servervalue(var73, 0);
               }

               var43.close();
               var56.close();
               var66.close();
            } catch (Exception var8) {
               var31 = -1;
            }

            if (var31 == 0) {
               try {
                  this.gs.mstgs.remove(this.onstage);
               } catch (Exception var7) {
               }

               this.gs.mstgs.select(0);
               this.staction = 0;
            } else {
               this.staction = -1;
            }
         }

         if (this.staction == 4) {
            this.reco = -1;

            try {
               Socket var32 = new Socket("69.195.146.194", 7061);
               BufferedReader var44 = new BufferedReader(new InputStreamReader(var32.getInputStream()));
               PrintWriter var57 = new PrintWriter(var32.getOutputStream(), true);
               var57.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
               String var67 = var44.readLine();
               if (var67 != null) {
                  this.reco = this.servervalue(var67, 0);
                  if (this.reco == 0 || this.reco == 3 || this.reco > 10) {
                     this.tnickey = this.serverSvalue(var67, 1);
                     if (this.reco != -167) {
                        this.tclan = this.serverSvalue(var67, 2);
                        this.tclankey = this.serverSvalue(var67, 3);
                     } else {
                        this.tclan = "";
                        this.tclankey = "";
                     }
                  }
               }

               var32.close();
               var44.close();
               var57.close();
            } catch (Exception var12) {
               this.reco = -1;
            }

            if (this.reco != 0 && this.reco != 3 && this.reco <= 10) {
               this.staction = 3;
            } else {
               this.staction = 5;
            }

            System.gc();

            while (this.staction == 5) {
            }
         }

         if (this.staction == 2) {
            int var33 = -1;
            if (this.msloaded == 1) {
               for (int var45 = 1; var45 < this.gs.mstgs.getItemCount(); var45++) {
                  if (this.gs.mstgs.getItem(var45).equals(this.onstage)) {
                     var33 = 3;
                  }
               }
            }

            if (var33 == -1) {
               try {
                  Socket var46 = new Socket("69.195.146.194", 7061);
                  BufferedReader var58 = new BufferedReader(new InputStreamReader(var46.getInputStream()));
                  PrintWriter var68 = new PrintWriter(var46.getOutputStream(), true);
                  var68.println("18|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.onstage + "|");
                  String var74 = var58.readLine();
                  if (var74 != null) {
                     var33 = this.servervalue(var74, 0);
                  }

                  var46.close();
                  var58.close();
                  var68.close();
               } catch (Exception var6) {
                  var33 = -1;
               }
            }

            this.staction = -1;
            if (var33 == 0) {
               this.staction = 0;
               if (this.msloaded == 1) {
                  this.gs.mstgs.addstg(this.onstage);
               }
            }

            if (var33 == 3) {
               this.staction = -2;
            }

            if (var33 == 4) {
               this.staction = -3;
            }
         }

         this.stageaction = null;
      }
   }

   public int loadonlinecar(String var1, int var2) {
      try {
         String var3 = Madness.corsProxy + "http://multiplayer.needformadness.com/cars/" + var1 + ".radq";
         var3 = var3.replace(' ', '_');
         URL var4 = new URL(var3);
         int var6 = var4.openConnection().getContentLength();
         DataInputStream var7 = new DataInputStream(var4.openStream());
         byte[] var8 = new byte[var6];
         var7.readFully(var8);
         ZipInputStream var5;
         if (var8[0] == 80 && var8[1] == 75 && var8[2] == 3) {
            var5 = new ZipInputStream(new ByteArrayInputStream(var8));
         } else {
            byte[] var9 = new byte[var6 - 40];

            for (int var10 = 0; var10 < var6 - 40; var10++) {
               byte var11 = 20;
               if (var10 >= 500) {
                  var11 = 40;
               }

               var9[var10] = var8[var10 + var11];
            }

            var5 = new ZipInputStream(new ByteArrayInputStream(var9));
         }

         ZipEntry var17 = var5.getNextEntry();
         if (var17 != null) {
            int var18 = Integer.valueOf(var17.getName());
            byte[] var19 = new byte[var18];
            int var12 = 0;

            while (var18 > 0) {
               int var13 = var5.read(var19, var12, var18);
               var12 += var13;
               var18 -= var13;
            }

            this.m.loadnew = true;
            this.bco[var2] = new ContO(var19, this.m, this.t);
            if (this.bco[var2].errd || this.bco[var2].npl <= 60 || this.bco[var2].maxR < 120) {
               var2 = -1;
            }

            if (var2 != -1) {
               this.bco[var2].shadow = true;
               this.bco[var2].noline = false;
               this.bco[var2].decor = false;
               this.bco[var2].tnt = 0;
               this.bco[var2].disp = 0;
               this.bco[var2].disline = 7;
               this.bco[var2].grounded = 1.0F;
               boolean var14 = true;
               if (this.bco[var2].keyz[0] < 0 || this.bco[var2].keyx[0] > 0) {
                  var14 = false;
               }

               if (this.bco[var2].keyz[1] < 0 || this.bco[var2].keyx[1] < 0) {
                  var14 = false;
               }

               if (this.bco[var2].keyz[2] > 0 || this.bco[var2].keyx[2] > 0) {
                  var14 = false;
               }

               if (this.bco[var2].keyz[3] > 0 || this.bco[var2].keyx[3] < 0) {
                  var14 = false;
               }

               if (!var14) {
                  var2 = -1;
               }
            }

            if (var2 != -1) {
               this.loadstat(var19, var1, this.bco[var2].maxR, this.bco[var2].roofat, this.bco[var2].wh, var2);
               if (this.names[var2].equals("")) {
                  var2 = -1;
               }
            }

            this.m.loadnew = false;
            var7.close();
            var5.close();
         } else {
            var2 = -1;
         }
      } catch (Exception var15) {
         var2 = -1;
      }

      System.gc();
      return var2;
   }

   public void loadmystages(CheckPoints var1) {
      String[] var2 = new String[700];
      int var3 = 0;
      String var4 = "";

      try {
         URL var5 = new URL(
            Madness.corsProxy + "http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
         );
         DataInputStream var12 = new DataInputStream(var5.openStream());

         while ((var4 = var12.readLine()) != null) {
            var4 = "" + var4.trim();
            if (var4.startsWith("mystages")) {
               boolean var7 = true;

               while (var7 && var3 < 700) {
                  var2[var3] = this.getSvalue("mystages", var4, var3);
                  if (var2[var3].equals("")) {
                     var7 = false;
                  } else {
                     var3++;
                  }
               }
            }
         }

         if (var3 > 0) {
            this.msloaded = 1;
         } else {
            this.msloaded = -2;
         }

         var12.close();
      } catch (Exception var8) {
         String var6 = "" + var8;
         if (var6.indexOf("FileNotFound") != -1) {
            this.msloaded = -2;
         } else {
            this.msloaded = -1;
         }
      }

      if (this.msloaded == 1) {
         this.gs.mstgs.hide();
         this.gs.mstgs.removeAll();
         this.gs.mstgs.add(this.gs.rd, "Select Stage");
         int var11 = 0;

         for (int var13 = 0; var13 < var3; var13++) {
            this.gs.mstgs.add(this.gs.rd, var2[var13]);
            if (var1.name.equals(var2[var13])) {
               var11 = var13 + 1;
               var1.top20 = 0;
            }
         }

         this.gs.mstgs.select(var11);
         this.gs.mstgs.show();
      }

      if (this.msloaded == -2) {
         this.gs.mstgs.hide();
         this.gs.mstgs.removeAll();
         this.gs.mstgs.add(this.gs.rd, "You have not published or added any stages...");
         this.gs.mstgs.select(0);
         this.gs.mstgs.show();
      }

      if (this.msloaded == -1) {
         this.gs.mstgs.hide();
         this.gs.mstgs.removeAll();
         this.gs.mstgs.add(this.gs.rd, "Failed to load stages, please try again later.");
         this.gs.mstgs.select(0);
         this.gs.mstgs.show();
      }

      System.gc();
   }

   public void loadtop20(int var1) {
      String[] var2 = new String[20];
      int var3 = 0;
      String var4 = "";

      try {
         String var5 = "A";
         if (var1 == 3) {
            var5 = "W";
         }

         if (var1 == 4) {
            var5 = "M";
         }

         URL var13 = new URL(Madness.corsProxy + "http://multiplayer.needformadness.com/tracks/top20/" + var5 + ".txt");
         DataInputStream var7 = new DataInputStream(var13.openStream());

         while ((var4 = var7.readLine()) != null) {
            var4 = "" + var4.trim();
            if (var4.startsWith("stages")) {
               boolean var8 = true;

               while (var8 && var3 < 20) {
                  var2[var3] = this.getSvalue("stages", var4, var3);
                  if (var2[var3].equals("")) {
                     var8 = false;
                  } else {
                     var3++;
                  }
               }
            }

            if (var4.startsWith("adds")) {
               for (int var14 = 0; var14 < var3; var14++) {
                  this.top20adds[var14] = this.getvalue("adds", var4, var14);
               }
            }
         }

         if (var3 > 0) {
            this.msloaded = var1;
         } else {
            this.msloaded = -2;
         }

         var7.close();
      } catch (Exception var9) {
         String var6 = "" + var9;
         if (var6.indexOf("FileNotFound") != -1) {
            this.msloaded = -2;
         } else {
            this.msloaded = -1;
         }
      }

      if (this.msloaded == var1) {
         this.gs.mstgs.hide();
         this.gs.mstgs.removeAll();
         this.gs.mstgs.add(this.gs.rd, "Select Stage");

         for (int var12 = 0; var12 < var3; var12++) {
            this.gs.mstgs.add(this.gs.rd, "N#" + (var12 + 1) + " " + var2[var12]);
         }

         this.gs.mstgs.select(0);
         this.gs.mstgs.show();
      }

      if (this.msloaded == -1 || this.msloaded == -2) {
         this.gs.mstgs.hide();
         this.gs.mstgs.removeAll();
         this.gs.mstgs.add(this.gs.rd, "Failed to load Top20 list, please try again later.");
         this.gs.mstgs.select(0);
         this.gs.mstgs.show();
      }

      System.gc();
   }

   public void loadclanstages(String var1) {
      if (!var1.equals("")) {
         String[] var2 = new String[700];
         int var3 = 0;
         String var4 = "";

         try {
            URL var5 = new URL(Madness.corsProxy + "http://multiplayer.needformadness.com/clans/" + var1 + "/stages.txt");

            DataInputStream var10;
            for (var10 = new DataInputStream(var5.openStream()); (var4 = var10.readLine()) != null && var3 < 700; var3++) {
               var2[var3] = var4;
            }

            if (var3 > 0) {
               this.msloaded = 7;
            } else {
               this.msloaded = -2;
            }

            var10.close();
         } catch (Exception var7) {
            String var6 = "" + var7;
            if (var6.indexOf("FileNotFound") != -1) {
               this.msloaded = -2;
            } else {
               this.msloaded = -1;
            }
         }

         if (this.msloaded == 7) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "Select Stage");

            for (int var9 = 0; var9 < var3; var9++) {
               this.gs.mstgs.add(this.gs.rd, var2[var9]);
            }

            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
         }

         if (this.msloaded == -1) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "Failed to load clan stages, please try again later.");
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
         }

         if (this.msloaded == -2) {
            this.gs.mstgs.hide();
            this.gs.mstgs.removeAll();
            this.gs.mstgs.add(this.gs.rd, "No stages have been added to your clan yet.");
            this.gs.mstgs.select(0);
            this.gs.mstgs.show();
         }

         System.gc();
      } else {
         this.msloaded = -2;
         this.gs.mstgs.hide();
         this.gs.mstgs.removeAll();
         this.gs.mstgs.add(this.gs.rd, "You are not a member of any clan yet.");
         this.gs.mstgs.select(0);
         this.gs.mstgs.show();
      }
   }

   public void loadstagemaker() {
      this.gs.mstgs.hide();
      this.gs.mstgs.removeAll();
      this.gs.mstgs.add(this.gs.rd, "Select Stage");
      int var1 = 0;
      File var2 = new File("" + Madness.fpath + "mystages/");
      if (var2.exists()) {
         String[] var3 = new File("" + Madness.fpath + "mystages/").list();

         for (int var4 = 0; var4 < var3.length; var4++) {
            if (var3[var4].toLowerCase().endsWith(".txt") && var1 < 200) {
               this.gs.mstgs.add(this.gs.rd, var3[var4].substring(0, var3[var4].length() - 4));
               var1++;
            }
         }
      }

      if (var1 != 0) {
         this.msloaded = 2;
      } else {
         this.gs.mstgs.add(this.gs.rd, "No stages where found in your 'mystages' folder.");
         this.msloaded = -1;
      }

      this.gs.mstgs.select(0);
      this.gs.mstgs.show();
   }

   public void loadcarmaker() {
      this.m.csky[0] = 170;
      this.m.csky[1] = 220;
      this.m.csky[2] = 255;
      this.m.cfade[0] = 255;
      this.m.cfade[1] = 220;
      this.m.cfade[2] = 220;
      this.m.snap[0] = 0;
      this.m.snap[1] = 0;
      this.m.snap[2] = 0;

      for (int var1 = 0; var1 < 40; var1++) {
         this.include[var1] = false;
      }

      this.nlcars = 16;
      File var4 = new File("" + Madness.fpath + "mycars/");
      if (var4.exists()) {
         String[] var2 = new File("" + Madness.fpath + "mycars/").list();

         for (int var3 = 0; var3 < var2.length; var3++) {
            if (var2[var3].toLowerCase().endsWith(".rad")
               && this.nlcars < 56
               && this.loadcar(var2[var3].substring(0, var2[var3].length() - 4), this.nlcars) == this.nlcars) {
               this.nlcars++;
            }
         }
      }

      System.gc();
      if (this.nlcars > 16) {
         this.lastload = 1;
      }
   }

   public int loadcar(String var1, int var2) {
      try {
         File var3 = new File("" + Madness.fpath + "mycars/" + var1 + ".rad");
         if (var3.exists()) {
            String var4 = "";
            BufferedReader var5 = new BufferedReader(new FileReader(var3));
            Object var6 = null;

            while ((var6 = var5.readLine()) != null) {
               var4 = var4 + "" + var6 + "\n";
            }

            var5.close();
            Object var9 = null;
            this.m.loadnew = true;
            this.bco[var2] = new ContO(var4.getBytes(), this.m, this.t);
            if (this.bco[var2].errd || this.bco[var2].npl <= 60) {
               var2 = -1;
            }

            if (var2 != -1) {
               this.bco[var2].shadow = true;
               this.bco[var2].noline = false;
               this.bco[var2].decor = false;
               this.bco[var2].tnt = 0;
               this.bco[var2].disp = 0;
               this.bco[var2].disline = 7;
               this.bco[var2].grounded = 1.0F;
               boolean var7 = true;
               if (this.bco[var2].keyz[0] < 0 || this.bco[var2].keyx[0] > 0) {
                  var7 = false;
               }

               if (this.bco[var2].keyz[1] < 0 || this.bco[var2].keyx[1] < 0) {
                  var7 = false;
               }

               if (this.bco[var2].keyz[2] > 0 || this.bco[var2].keyx[2] > 0) {
                  var7 = false;
               }

               if (this.bco[var2].keyz[3] > 0 || this.bco[var2].keyx[3] < 0) {
                  var7 = false;
               }

               if (!var7) {
                  var2 = -1;
               }
            }

            if (var2 != -1) {
               this.loadstat(var4.getBytes(), var1, this.bco[var2].maxR, this.bco[var2].roofat, this.bco[var2].wh, var2);
               if (this.names[var2].equals("")) {
                  var2 = -1;
               }
            }

            this.m.loadnew = false;
         } else {
            var2 = -1;
         }
      } catch (Exception var8) {
         var2 = -1;
         System.out.println("Error Loading Car: " + var8);
      }

      System.gc();
      return var2;
   }
}
