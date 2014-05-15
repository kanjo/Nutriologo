package com.kanjo.health.e_diet.app.UI.CustomViews;

import android.annotation.TargetApi;
import android.content.Context;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.kanjo.health.e_diet.app.R;


/**
 * TODO: document your custom view class.
 *
 * TODO: PASS THE Hour
 */
public class HorarioView extends View {


    private TextPaint mTextPaint;

    //Hold reference to circles
    private Paint mCirclePaint;

    //Hold reference to lines around
    private Paint mMarkerPaint;

    //Draw circle with color
    private Paint mCircleHourPaint;

    //Bitmap to get the background
    private Bitmap bitmap;

    private Bitmap mScaledBitmap;

    public HorarioView(Context context) {
        super(context);
        init(null, 0);
    }

    public HorarioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HorarioView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }


    private void init(AttributeSet attrs, int defStyle) {

        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(Color.argb(255,58,144,56));
        mCirclePaint.setStrokeWidth(1.5f);
        //mCirclePaint.setShadowLayer(0.2f, 0.0f, 0.2f, Color.argb(255,145,169,142));
        mCirclePaint.setShadowLayer(.7f,.7f,.7f,Color.argb(255,145,169,142));

        mMarkerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mMarkerPaint.setStrokeWidth(1.5f);
        mMarkerPaint.setStyle(Paint.Style.STROKE);
        mMarkerPaint.setColor(Color.argb(255,58,144,56));
        //mMarkerPaint.setShadowLayer(0.2f, 0.0f, 0.2f, Color.argb(255,145,169,142));
        //mMarkerPaint.setShadowLayer(3,1.5f,1.5f,Color.argb(255,145,169,142));
        mMarkerPaint.setShadowLayer(.7f,.7f,.7f,Color.argb(255,145,169,142));

        mCircleHourPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircleHourPaint.setColor(Color.argb(255,187,230,57));

        //153 204   0
        //129,188,0
        mCircleHourPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setFakeBoldText(true);
        mTextPaint.setSubpixelText(true);
        mTextPaint.setTextSize(55);

        mTextPaint.setShadowLayer(3,1.5f,1.5f,Color.argb(255,145,169,142));

    }

    @Override
    protected void onDraw(Canvas canvas) {

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.puntitos);
        mScaledBitmap = Bitmap.createScaledBitmap(bitmap,getWidth(),getHeight(),true);
        canvas.drawBitmap(mScaledBitmap,0,0,null);

        //   The view will be drawn always in portrait mode

        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        //Center

        int px = width/2;
        int py = height/2;

        int outerDiameter = (int)Math.ceil(width*.51);//51
        int outerRadio = outerDiameter/2;
        int innerDiameter = (int)Math.ceil(width*.37);//37
        int innerRadio = innerDiameter/2;//37

        int distanceBetweenHourLineMeasureAndOuterDiameter ,hourLineMeasure;
        distanceBetweenHourLineMeasureAndOuterDiameter = hourLineMeasure= (int)Math.ceil(width*.045);


        //Initial Point is in the center of the circle
        //given by height - diameter <= space left in the screen
        //divided by two
        int initialPointCircle = ((height - outerDiameter)/2);

        canvas.drawArc(new RectF((width-outerDiameter)/2,                        //left
                                 (height-outerDiameter)/2,                      //top
                                 outerDiameter+((width-outerDiameter)/2) ,//right
                                 outerDiameter+initialPointCircle),       //bottom
                        270,
                        240,
                        false,
                mCirclePaint
        );


        canvas.drawArc(new RectF((width - innerDiameter) / 2,
                        (height - innerDiameter) / 2,
                        innerDiameter + ((width - innerDiameter) / 2),
                        innerDiameter + ((height - innerDiameter) / 2)),
                270,
                240,
                false,
                mCirclePaint
        );
        //Line that join outer circle and inner circle at the very top
        canvas.drawLine((width) / 2, (height - outerDiameter) / 2, (width) / 2, (height - innerDiameter) / 2, mMarkerPaint);

        //8:00
        int X = ( (width / 2) - outerRadio) //Initial Point of the outer circle 301
                + (outerRadio - (int) Math.ceil( Math.cos(Math.toRadians(30)) * (outerRadio)));


        int Y = (height/2)  //The center of the circle is always half of the screen  //988
                + (int) Math.ceil(Math.sin(Math.toRadians(30))*outerRadio ); // this is how much we will have to move to down

        int X1 = ( (width / 2) - innerRadio) //Initial Point of the outer circle 301
                + (innerRadio - (int) Math.ceil( Math.cos(Math.toRadians(30)) * (innerRadio)));;


        int Y1 = (height/2)  //The center of the circle is always half of the screen  //988
                + (int) Math.ceil(Math.sin(Math.toRadians(30))*innerRadio ); // this is how much we will have to move to down


        int distance = (int)Math.ceil(Math.sqrt(Math.pow(X1-X,2) + Math.pow(Y1-Y,2)));


        canvas.save();

        canvas.rotate(-30,px,py);
        //canvas.drawLine(X,Y,X1,Y1, mMarkerPaint);

        RectF rectF = new RectF( ((int)Math.ceil(width/2)-outerRadio),
                (height/2)-(distance/2)+1,
                (int)(Math.ceil(width/2)-innerRadio)-1,
                (height/2)+(distance/2));



        canvas.drawArc(rectF,
                180,
                180,
                false,
                mCirclePaint
        );


        canvas.restore();
        canvas.save();

        //TODO : RESTORE
        //Draw filled circle
        canvas.drawCircle(width/2,height/2,innerRadio-2, mCircleHourPaint);
        canvas.restore();
        canvas.save();

         X = ((width/2)-outerRadio) - (distanceBetweenHourLineMeasureAndOuterDiameter +hourLineMeasure);

        X1 = X + hourLineMeasure;

        //Loop for painting the hours
        for (int i = -180 ; i < 180 ; i += 10) {
            if(i%30==0) {
                canvas.drawLine(X, height / 2, X1, height / 2, mMarkerPaint);

                canvas.save();
            }
            canvas.rotate(10, px, py);


        }
        canvas.save();

        canvas.drawText("8:00",width/2 -75,height/2+25 ,mTextPaint);
        canvas.save();
        canvas.restore();
    }
    /*
    private enum CompassDirection { N, NNE, NE, ENE,
        E, ESE, SE, SSE,
        S, SSW, SW, WSW,
        W, WNW, NW, NNW }

    private Paint markerPaint;
    private Paint textPaint;
    private Paint circlePaint;
    private int textHeight;

    int[] borderGradientColors;
    float[] borderGradientPositions;

    int[] glassGradientColors;
    float[] glassGradientPositions;

    int skyHorizonColorFrom;
    int skyHorizonColorTo;
    int groundHorizonColorFrom;
    int groundHorizonColorTo;

    public void setBearing(float _bearing) {
        bearing = _bearing;
    }
    public float getBearing() {
        return bearing;
    }
    private float bearing;

    public float getPitch() {
        return pitch;
    }
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
    float pitch = 10;

    public float getRoll() {
        return roll;
    }
    public void setRoll(float roll) {
        this.roll = roll;
    }
    float roll = 45;

    public HorarioView(Context context) {
        super(context);
        initCompassView();
    }

    public HorarioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCompassView();
    }

    public HorarioView(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);
        initCompassView();
    }

    protected void initCompassView() {
        setFocusable(true);
        Resources r = this.getResources();

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(R.color.background_color);
        circlePaint.setStrokeWidth(1);
        circlePaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(r.getColor(R.color.text_color));
        textPaint.setFakeBoldText(true);
        textPaint.setSubpixelText(true);
        textPaint.setTextAlign(Paint.Align.LEFT);

        textHeight = (int)textPaint.measureText("yY");

        markerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        markerPaint.setColor(r.getColor(R.color.marker_color));
        markerPaint.setAlpha(200);
        markerPaint.setStrokeWidth(1);
        markerPaint.setStyle(Paint.Style.STROKE);
        markerPaint.setShadowLayer(2, 1, 1, r.getColor(R.color.shadow_color));

        borderGradientColors = new int[4];
        borderGradientPositions = new float[4];

        borderGradientColors[3] = r.getColor(R.color.outer_border);
        borderGradientColors[2] = r.getColor(R.color.inner_border_one);
        borderGradientColors[1] = r.getColor(R.color.inner_border_two);
        borderGradientColors[0] = r.getColor(R.color.inner_border);
        borderGradientPositions[3] = 0.0f;
        borderGradientPositions[2] = 1-0.03f;
        borderGradientPositions[1] = 1-0.06f;
        borderGradientPositions[0] = 1.0f;

        glassGradientColors = new int[5];
        glassGradientPositions = new float[5];

        int glassColor = 245;
        glassGradientColors[4] = Color.argb(65, glassColor, glassColor, glassColor);
        glassGradientColors[3] = Color.argb(100, glassColor, glassColor, glassColor);
        glassGradientColors[2] = Color.argb(50, glassColor, glassColor, glassColor);
        glassGradientColors[1] = Color.argb(0, glassColor, glassColor, glassColor);
        glassGradientColors[0] = Color.argb(0, glassColor, glassColor, glassColor);
        glassGradientPositions[4] = 1-0.0f;
        glassGradientPositions[3] = 1-0.06f;
        glassGradientPositions[2] = 1-0.10f;
        glassGradientPositions[1] = 1-0.20f;
        glassGradientPositions[0] = 1-1.0f;

        skyHorizonColorFrom = r.getColor(R.color.horizon_sky_from);
        skyHorizonColorTo = r.getColor(R.color.horizon_sky_to);

        groundHorizonColorFrom = r.getColor(R.color.horizon_ground_from);
        groundHorizonColorTo = r.getColor(R.color.horizon_ground_to);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // The compass is a circle that fills as much space as possible.
        // Set the measured dimensions by figuring out the shortest boundary,
        // height or width.
        int measuredWidth = measure(widthMeasureSpec);
        int measuredHeight = measure(heightMeasureSpec);

        int d = Math.min(measuredWidth, measuredHeight);

        setMeasuredDimension(d, d);
    }

    private int measure(int measureSpec) {
        int result = 0;

        // Decode the measurement specifications.
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.UNSPECIFIED) {
            // Return a default size of 200 if no bounds are specified.
            result = 200;
        } else {
            // As you want to fill the available space
            // always return the full available bounds.
            result = specSize;
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float ringWidth = textHeight + 4;

        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        int px = width/2;
        int py = height/2;
        Point center = new Point(px, py);

        int radius = Math.min(px, py)-2;

        RectF boundingBox = new RectF(center.x - radius,
                center.y - radius,
                center.x + radius,
                center.y + radius);

        RectF innerBoundingBox = new RectF(center.x - radius + ringWidth,
                center.y - radius + ringWidth,
                center.x + radius - ringWidth,
                center.y + radius - ringWidth);

        float innerRadius = innerBoundingBox.height()/2;

        RadialGradient borderGradient = new RadialGradient(px, py, radius,
                borderGradientColors,
                borderGradientPositions,
                Shader.TileMode.CLAMP);
        Paint pgb = new Paint();
        pgb.setShader(borderGradient);

        Path outerRingPath = new Path();
        outerRingPath.addOval(boundingBox, Path.Direction.CW);

        canvas.drawPath(outerRingPath, pgb);

        LinearGradient skyShader = new LinearGradient(center.x, innerBoundingBox.top,
                center.x, innerBoundingBox.bottom,
                skyHorizonColorFrom, skyHorizonColorTo,
                Shader.TileMode.CLAMP);
        Paint skyPaint = new Paint();
        skyPaint.setShader(skyShader);

        LinearGradient groundShader = new LinearGradient(center.x, innerBoundingBox.top,
                center.x, innerBoundingBox.bottom,
                groundHorizonColorFrom, groundHorizonColorTo,
                Shader.TileMode.CLAMP);
        Paint groundPaint = new Paint();
        groundPaint.setShader(groundShader);

        float tiltDegree = pitch;
        while (tiltDegree > 90 || tiltDegree < -90)
        {
            if (tiltDegree > 90) tiltDegree = -90 + (tiltDegree - 90);
            if (tiltDegree < -90) tiltDegree = 90 - (tiltDegree + 90);
        }

        float rollDegree = roll;
        while (rollDegree > 180 || rollDegree < -180)
        {
            if (rollDegree > 180) rollDegree = -180 + (rollDegree - 180);
            if (rollDegree < -180) rollDegree = 180 - (rollDegree + 180);
        }

        Path skyPath = new Path();
        skyPath.addArc(innerBoundingBox, -tiltDegree, (180 + (2 * tiltDegree)));

        canvas.rotate(-rollDegree, px, py);
        canvas.drawOval(innerBoundingBox, groundPaint);
        canvas.drawPath(skyPath, skyPaint);
        canvas.drawPath(skyPath, markerPaint);

        int markWidth = radius/3;
        int startX = center.x-markWidth;
        int endX = center.x+markWidth;

        double h = innerRadius*Math.cos(Math.toRadians(90-tiltDegree));
        double justTiltY = center.y - h;

        float pxPerDegree = (innerBoundingBox.height()/2)/45f;

        for (int i = 90; i >= -90; i -= 10)
        {
            double ypos = justTiltY + i*pxPerDegree;

            // Only display the scale within the inner face.
            if ((ypos < (innerBoundingBox.top + textHeight)) ||
                    (ypos > innerBoundingBox.bottom - textHeight))
                continue;

            // Draw a line and the tilt angle for each scale increment.
            canvas.drawLine(startX, (float)ypos, endX, (float)ypos, markerPaint);
            int displayPos = (int)(tiltDegree - i);
            String displayString = String.valueOf(displayPos);
            float stringSizeWidth = textPaint.measureText(displayString);
            canvas.drawText(displayString,
                    (int)(center.x-stringSizeWidth/2), (int)(ypos)+1,
                    textPaint);
        }

        markerPaint.setStrokeWidth(2);
        canvas.drawLine(center.x - radius / 2, (float)justTiltY,
                center.x + radius / 2, (float)justTiltY,
                markerPaint);
        markerPaint.setStrokeWidth(1);

        // Draw the arrow
        Path rollArrow = new Path();
        rollArrow.moveTo(center.x - 3, (int)innerBoundingBox.top + 14);
        rollArrow.lineTo(center.x, (int)innerBoundingBox.top + 10);
        rollArrow.moveTo(center.x + 3, innerBoundingBox.top + 14);
        rollArrow.lineTo(center.x, innerBoundingBox.top + 10);
        canvas.drawPath(rollArrow, markerPaint);
        // Draw the string
        String rollText = String.valueOf(rollDegree);
        double rollTextWidth = textPaint.measureText(rollText);
        canvas.drawText(rollText,
                (float)(center.x - rollTextWidth / 2), innerBoundingBox.top + textHeight + 2,
                textPaint);

        canvas.restore();

        canvas.save();
        canvas.rotate(180, center.x, center.y);
        for (int i = -180; i < 180; i += 10)
        {
            // Show a numeric value every 30 degrees
            if (i % 30 == 0) {
                String rollString = String.valueOf(i*-1);
                float rollStringWidth = textPaint.measureText(rollString);
                PointF rollStringCenter = new PointF(center.x-rollStringWidth / 2, innerBoundingBox.top+1+textHeight);

                canvas.drawText(rollString,
                        rollStringCenter.x, rollStringCenter.y,
                        textPaint);
            }
            // Otherwise draw a marker line
            else {
                canvas.drawLine(center.x, (int)innerBoundingBox.top,
                        center.x, (int)innerBoundingBox.top + 5,
                        markerPaint);
            }

            canvas.rotate(10, center.x, center.y);
        }
        canvas.restore();

        canvas.save();
        canvas.rotate(-1*(bearing), px, py);

        double increment = 22.5;

        for (double i = 0; i < 360; i += increment)
        {
            CompassDirection cd = CompassDirection.values()[(int)(i / 22.5)];
            String headString = cd.toString();

            float headStringWidth = textPaint.measureText(headString);
            PointF headStringCenter = new PointF(center.x - headStringWidth / 2,
                    boundingBox.top + 1 + textHeight);

            if (i % increment == 0)
                canvas.drawText(headString,
                        headStringCenter.x, headStringCenter.y,
                        textPaint);
            else
                canvas.drawLine(center.x, (int)boundingBox.top,
                        center.x, (int)boundingBox.top + 3,
                        markerPaint);

            canvas.rotate((int)increment, center.x, center.y);
        }
        canvas.restore();

        RadialGradient glassShader = new RadialGradient(px, py,
                (int)innerRadius,
                glassGradientColors,
                glassGradientPositions,
                Shader.TileMode.CLAMP);
        Paint glassPaint = new Paint();
        glassPaint.setShader(glassShader);

        canvas.drawOval(innerBoundingBox, glassPaint);

        // Draw the outer ring
        canvas.drawOval(boundingBox, circlePaint);

        // Draw the inner ring
        circlePaint.setStrokeWidth(2);
        canvas.drawOval(innerBoundingBox, circlePaint);

        canvas.restore();
    }*/
}
