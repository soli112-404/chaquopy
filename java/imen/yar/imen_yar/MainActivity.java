package imen.yar.imen_yar;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.imen_yar.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ImageButton menu;
    ImageButton b_main;
    Button b_link;
    TextView text;
    DrawerLayout mDrawer;
    Display displaySize;
    Point size;
    int width;
    int height;
    int iii = 0;
    int activity = 0;
    DrawerLayout.LayoutParams params_b;
    DrawerLayout.LayoutParams params_t;
    String interpreterOutput = "";
    String path;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This is an "Activity" we use in this section
        setContentView(R.layout.activity_main);
        // Activity elements
        menu = findViewById(R.id.mct);
        b_main = findViewById(R.id.b_main);
        b_link = findViewById(R.id.b_link);
        text = findViewById(R.id.textView);
        mDrawer = findViewById(R.id.drawer_layout);
        // get screen size
        displaySize = getWindowManager().getDefaultDisplay();
        size = new Point();
        displaySize.getSize(size);
        width = size.x;
        height = size.y;
        // To adjust size of the elements
        params_b = (DrawerLayout.LayoutParams) b_main.getLayoutParams();
        params_t = (DrawerLayout.LayoutParams) text.getLayoutParams();
        // menu
        menu.setOnClickListener(v -> mDrawer.openDrawer(GravityCompat.START));
        b_link.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        });
        NavigationView nvDrawer = findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        // To run Python Interpreter
        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        // Responsive (Not completed)
        if(width == 1080 && height == 1920){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(750,750));
            params_b.setMargins(165, 549,165,549);//546
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(765,135));
            params_t.setMargins(0, 1350,315,435);
            text.setLayoutParams(params_t);
        }else if(width == 720 && height == 1280){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(500, 500));
            params_b.setMargins(110, 364,110,364);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(510,90));
            params_t.setMargins(0, 900,210,290);
            text.setLayoutParams(params_t);
        }else if(width == 1440 && height == 2560){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(1000, 1000));
            params_b.setMargins(220, 780,220,780);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1440,180));
            params_t.setMargins(0, 1800,420,580);
            text.setLayoutParams(params_t);
        }else if(width == 540 && height == 960){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(375, 375));
            params_b.setMargins(83, 293,82,292);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(540,68));
            params_t.setMargins(0, 675,158,217);
            text.setLayoutParams(params_t);
        }else if(width == 1080 && height == 2400){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(750, 750));
            params_b.setMargins(165, 825,165,825);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1080,135));
            params_t.setMargins(0, 1688,315,577);
            text.setLayoutParams(params_t);
        }else if(width == 1080 && height == 2310){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(750, 750));
            params_b.setMargins(165, 780,165,780);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1080,135));
            params_t.setMargins(0, 1624,315,551);
            text.setLayoutParams(params_t);
        }else if(width == 1080 && height == 2340){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(750, 750));
            params_b.setMargins(165, 795,165,795);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1080,135));
            params_t.setMargins(0, 1645,315,560);
            text.setLayoutParams(params_t);
        }else if(width == 1440 && height == 3200){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(1000, 1000));
            params_b.setMargins(220, 1100,220,1100);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1440,180));
            params_t.setMargins(0, 2250,0,725);
            text.setLayoutParams(params_t);
        }else if(width == 1440 && height == 3088){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(1000, 1000));
            params_b.setMargins(220, 1044,220,1044);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1440,180));
            params_t.setMargins(0, 2171,0,737);
            text.setLayoutParams(params_t);
        }else if(width == 1440 && height == 3040){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(1000, 1000));
            params_b.setMargins(220, 1020,220,1020);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1440,180));
            params_t.setMargins(0, 2138,0,722);
            text.setLayoutParams(params_t);
        }else if(width == 1440 && height == 2280){
            //Button size
            b_main.setLayoutParams(new DrawerLayout.LayoutParams(1000, 1000));
            params_b.setMargins(220, 640,220,640);
            b_main.setLayoutParams(params_b);
            //Text size
            text.setLayoutParams(new DrawerLayout.LayoutParams(1440,180));
            params_t.setMargins(0, 1603,0,497);
            text.setLayoutParams(params_t);
        }else{
            menu.setBackground(getDrawable(R.drawable.white));
            b_main.setBackground(getDrawable(R.drawable.size_screen_error));
            text.setText("");
        }
        b_main.setOnClickListener(view ->{
            if(activity == 0){
                Intent intent = new Intent();
                intent.setType("*/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
                activity = 1;
            }else if(activity == 1){
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                activity = 0;
            }
        });
    }
    // menu item:
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
            menuItem -> {
                selectDrawerItem(menuItem);
                return true;
            }
        );
    }
    @SuppressLint("NonConstantResourceId")
    public void selectDrawerItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_switch:
            case R.id.nav_switch2:
            case R.id.nav_switch3:
            case R.id.nav_switch4:
            case R.id.nav_switch5:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.nav_switch6:
                intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            break;
            default:
                super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("SetTextI18n")
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = this;

            path = RealPathUtil.getRealPath(context,uri);

            if(path != null){
                class code_file extends Thread{
                    public void run(){
                        Python py = Python.getInstance();

                        String code = "import vt\n";
                        code += "import hashlib\n";
                        code += "import time\n";

                        code += "client = vt.Client(\"e9481497c3198559e299e966ec79be2ece56bf903cd0308474f8e3059aad6ee5\")\n";

                        code += "def check():\n";
                        code += "    try:\n";
                        code += "        with open(r\"" + path + "\",\"rb\") as f:\n";
                        code += "            bytes = f.read() # read the entire file as bytes\n";
                        code += "            readable_hash = hashlib.sha256(bytes).hexdigest()\n";
                        code += "        file = client.get_object(\"/files/\" + readable_hash)\n";
                        code += "        x = str(file.last_analysis_stats)\n";
                        code += "        n = 109\n";
                        code += "        if x[n] + x[n+1] + x[n+2] + x[n+3] + x[n+4] + x[n+5] + x[n+6] + x[n+7] + x[n+8] == \"malicious\":\n";
                        code += "            t = x[n + 12]\n";
                        code += "        elif x[n+1] + x[n+2] + x[n+3] + x[n+4] + x[n+5] + x[n+6] + x[n+7] + x[n+8] + x[n+9] == \"malicious\":\n";
                        code += "            t = x[n + 13]\n";
                        code += "        elif x[n+2] + x[n+3] + x[n+4] + x[n+5] + x[n+6] + x[n+7] + x[n+8] + x[n+9] + x[n+10] == \"malicious\":\n";
                        code += "            t = x[n + 14]\n";
                        code += "        elif x[n+3] + x[n+4] + x[n+5] + x[n+6] + x[n+7] + x[n+8] + x[n+9] + x[n+10] + x[n+11] == \"malicious\":\n";
                        code += "            t = x[n + 15]\n";
                        code += "        elif x[n+4] + x[n+5] + x[n+6] + x[n+7] + x[n+8] + x[n+9] + x[n+10] + x[n+11] + x[n+12] == \"malicious\":\n";
                        code += "            t = x[n + 16]\n";
                        code += "        elif x[n+5] + x[n+6] + x[n+7] + x[n+8] + x[n+9] + x[n+10] + x[n+11] + x[n+12] + x[n+13] == \"malicious\":\n";
                        code += "            t = x[n + 17]\n";
                        code += "        elif x[n+6] + x[n+7] + x[n+8] + x[n+9] + x[n+10] + x[n+11] + x[n+12] + x[n+13] + x[n+14] == \"malicious\":\n";
                        code += "            t = x[n + 18]\n";
                        code += "        if t == \"0\":\n";
                        code += "            print(\"file is safe\")\n";
                        code += "        else:\n";
                        code += "            print(\"file isn't safe\")\n";
                        code += "    except:\n";
                        code += "        #print(\"oh. it's a new file!!\")\n";
                        code += "        check2()\n";

                        code += "def check2(): \n";
                        code += "    with open(r\"" + path + "\", \"rb\") as f:\n";
                        code += "        analysis = client.scan_file(f, wait_for_completion=True)\n";
                        code += "    while True:\n";
                        code += "        print(\"checking\")\n";
                        code += "        analysis = client.get_object(\"/analyses/{}\", analysis.id)\n";
                        code += "        #print(analysis.status)\n";
                        code += "        if analysis.status == \"completed\":\n";
                        code += "            check()\n";
                        code += "            break\n";
                        code += "        time.sleep(10)\n";

                        code += "check()\n";

                        PyObject sys = py.getModule("sys");
                        PyObject io = py.getModule("io");
                        PyObject console = py.getModule("interpreter");
                        PyObject textOutputStream = io.callAttr("StringIO");

                        try {
                            console.callAttrThrows("mainTextCode", code);
                            interpreterOutput = String.valueOf(textOutputStream.callAttr("getvalue"));
                        }catch (PyException e){
                            interpreterOutput = e.getMessage();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }

                        sys.put("stdout", textOutputStream);
                        iii = 1;
                    }
                }
                code_file mycode_file = new code_file();
                mycode_file.start();
                class while_code extends Thread{
                    public void run(){
                        if(iii == 1){
                            String output_one = "safe\n";
                            output_one += "Unclosed client session\n";
                            output_one += "client_session: <aiohttp.client.ClientSession object at 0x00000252B05A5F40>\n";
                            output_one += "Unclosed connector\n";
                            output_one += "connections: ['[(<aiohttp.client_proto.ResponseHandler object at 0x00000252B05D3640>, 243493.796)]']\n";
                            output_one += "connector: <aiohttp.connector.TCPConnector object at 0x00000252ADC3CA90>";

                            String output_two = "isn't safe\n";
                            output_two += "Unclosed client session\n";
                            output_two += "client_session: <aiohttp.client.ClientSession object at 0x00000252B05A5F40>\n";
                            output_two += "Unclosed connector\n";
                            output_two += "connections: ['[(<aiohttp.client_proto.ResponseHandler object at 0x00000252B05D3640>, 243493.796)]']\n";
                            output_two += "connector: <aiohttp.connector.TCPConnector object at 0x00000252ADC3CA90>";

                            if (interpreterOutput != null) {
                                System.out.println(interpreterOutput);
                                if(interpreterOutput.equals(output_one)){
                                    System.out.println("file is safe");
                                    text.setText("safe");
                                    System.out.println(interpreterOutput);
                                }else if(interpreterOutput.equals(output_two)){
                                    System.out.println("file isn't safe!");
                                    text.setText("isn't safe!");
                                    System.out.println(interpreterOutput);
                                }
                            }
                            iii = 0;
                        }
                    }
                }
                while_code mywhile_code = new while_code();
                mywhile_code.start();
            }
        }
    }
}
//salam
