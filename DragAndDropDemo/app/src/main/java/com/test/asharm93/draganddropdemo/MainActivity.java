package com.test.asharm93.draganddropdemo;

import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
   ImageView ima;
    private static final String IMAGEVIEW_TAG="Android Logo";
    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ima=(ImageView)findViewById(R.id.iv_logo);

        //Sets the Tag
        ima.setTag(IMAGEVIEW_TAG);

        ima.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item=new ClipData.Item((CharSequence) view.getTag());

                String[] mimeTypes={ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData dragData=new ClipData(view.getTag().toString(),mimeTypes,item);

                //Instantiates the drag shadow builder
                View.DragShadowBuilder myShadow=new View.DragShadowBuilder(ima);

                //Starts the drag
                view.startDrag(dragData,//the data to be dragged
                        myShadow,//the drag shadow builder
                        null,//no need to use local data
                        0  //flags(not currently used, set to 0
                );


                return true;
            }
        });

        //Create and set the drag event listener for the view
        ima.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                switch (dragEvent.getAction()){
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams=(RelativeLayout.LayoutParams)view.getLayoutParams();
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_STARTED");
                        //Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x_cord=(int) dragEvent.getX();
                        int y_cord=(int) dragEvent.getY();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_EXITED");
                        x_cord=(int) dragEvent.getX();
                        y_cord=(int) dragEvent.getY();
                        layoutParams.leftMargin=x_cord;
                        layoutParams.topMargin=y_cord;
                        view.setLayoutParams(layoutParams);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(msg,"Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord=(int) dragEvent.getX();
                        y_cord=(int) dragEvent.getY();
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(msg,"DragEvent.ACTION_DRAG_ENDED");
                        //Do nothing
                        break;

                    default:break;
                }


                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
