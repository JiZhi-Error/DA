package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.b;

public final class a extends FrameLayout {
    private final b SNr;
    public FlutterMutatorsStack SPq;
    private float SPr;
    public int left;
    public int top;

    public a(Context context, float f2, b bVar) {
        super(context, null);
        this.SPr = f2;
        this.SNr = bVar;
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(214967);
        canvas.save();
        for (Path path : this.SPq.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset((float) (-this.left), (float) (-this.top));
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(214967);
    }

    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(214968);
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
        AppMethodBeat.o(214968);
    }

    private Matrix getPlatformViewMatrix() {
        AppMethodBeat.i(214969);
        Matrix matrix = new Matrix(this.SPq.getFinalMatrix());
        matrix.preScale(1.0f / this.SPr, 1.0f / this.SPr);
        matrix.postTranslate((float) (-this.left), (float) (-this.top));
        AppMethodBeat.o(214969);
        return matrix;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(214970);
        if (this.SNr == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(214970);
            return onTouchEvent;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) this.left, (float) this.top);
        boolean a2 = this.SNr.a(motionEvent, matrix);
        AppMethodBeat.o(214970);
        return a2;
    }
}
