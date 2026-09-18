package com.velocityauto.app;

import android.app.*;
import android.os.*;
import android.content.*;
import android.graphics.Color;
import android.net.Uri;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout content;
    int red=Color.rgb(225,29,46), dark=Color.rgb(9,13,20), card=Color.rgb(18,25,35);

    TextView tv(String s,int size){
        TextView t=new TextView(this);
        t.setText(s); t.setTextColor(Color.WHITE); t.setTextSize(size);
        t.setPadding(22,18,22,18); return t;
    }
    Button btn(String s){
        Button b=new Button(this); b.setText(s); b.setTextColor(Color.WHITE);
        b.setBackgroundColor(red); return b;
    }
    void openUrl(String u){ startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(u))); }

    @Override public void onCreate(Bundle b){ super.onCreate(b); showHome(); }

    void base(String title){
        LinearLayout root=new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL); root.setBackgroundColor(dark);

        TextView bar=tv("VELOCITY AUTO",22); bar.setTypeface(null,1);
        bar.setBackgroundColor(dark); root.addView(bar,new LinearLayout.LayoutParams(-1,70));

        content=new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL); content.setPadding(22,15,22,30);
        ScrollView sc=new ScrollView(this); sc.addView(content);
        root.addView(sc,new LinearLayout.LayoutParams(-1,0,1));
        setContentView(root);

        TextView h=tv(title,32); h.setTypeface(null,1); content.addView(h);
    }

    void showHome(){
        base("Reliable car care.");
        content.addView(tv("AUTOMOTIVE ENGINEERING & CAR SERVICES\n\nProfessional vehicle servicing, diagnostics and repairs.",18));

        Button book=btn("BOOK A SERVICE");
        book.setOnClickListener(v->showBooking()); content.addView(book);

        Button wa=btn("WHATSAPP US");
        wa.setOnClickListener(v->openUrl("https://wa.me/27789451908")); content.addView(wa);

        Button services=btn("VIEW SERVICES");
        services.setOnClickListener(v->showServices()); content.addView(services);

        Button call=btn("CALL 067 658 9756");
        call.setOnClickListener(v->openUrl("tel:0676589756")); content.addView(call);

        content.addView(tv("\nVELOCITY AUTO REPAIRS/SERVICES\nCape Town • Mthatha\n\nCall: 067 658 9756\nWhatsApp: 078 945 1908\nEmail: Masikolitha@gmail.com",16));
    }

    void showServices(){
        base("Our Services");
        String[] ss={"🔧 Engine Repairs","🖥 Diagnostics","🛞 Brakes & Suspension","🛢 Car Servicing","⚙ Automotive Engineering","🚗 General Repairs"};
        for(String s:ss){
            TextView x=tv(s+"\nProfessional inspection, maintenance and repair.",18);
            x.setBackgroundColor(card);
            LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2);
            p.setMargins(0,0,0,14); content.addView(x,p);
        }
        Button b=btn("BOOK NOW"); b.setOnClickListener(v->showBooking()); content.addView(b);
    }

    void showBooking(){
        base("Book a Service");
        EditText name=field("Your name"), phone=field("Phone number"),
                vehicle=field("Vehicle e.g. VW Polo"), problem=field("Describe the problem");

        Spinner sp=new Spinner(this);
        String[] items={"Choose service","Car Servicing","Engine Repairs","Diagnostics",
                "Brakes & Suspension","General Repairs","Automotive Engineering"};
        sp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items));

        content.addView(name); content.addView(phone); content.addView(vehicle);
        content.addView(sp); content.addView(problem);

        Button send=btn("SEND BOOKING VIA WHATSAPP");
        send.setOnClickListener(v->{
            String msg="Hello Velocity Auto Repairs/Services. I want to book a service.%0A"
                    +"Name: "+name.getText()+"%0APhone: "+phone.getText()
                    +"%0AVehicle: "+vehicle.getText()+"%0AService: "
                    +sp.getSelectedItem()+"%0AProblem: "+problem.getText();
            openUrl("https://wa.me/27789451908?text="+Uri.encode(msg));
        });
        content.addView(send);
    }

    EditText field(String hint){
        EditText e=new EditText(this);
        e.setHint(hint); e.setHintTextColor(Color.LTGRAY); e.setTextColor(Color.WHITE);
        e.setPadding(16,12,16,12); e.setBackgroundColor(card);
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,60);
        p.setMargins(0,0,0,12); e.setLayoutParams(p); return e;
    }
}
