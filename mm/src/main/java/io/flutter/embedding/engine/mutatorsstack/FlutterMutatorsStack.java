package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Keep
public class FlutterMutatorsStack {
    private List<Path> finalClippingPaths = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<a> mutators = new ArrayList();

    public enum b {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY;

        public static b valueOf(String str) {
            AppMethodBeat.i(214975);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(214975);
            return bVar;
        }

        static {
            AppMethodBeat.i(214976);
            AppMethodBeat.o(214976);
        }
    }

    public class a {
        private b SPs;
        Matrix gT;
        private Rect rect;

        public a(Rect rect2) {
            this.SPs = b.CLIP_RECT;
            this.rect = rect2;
        }

        public a(Matrix matrix) {
            this.SPs = b.TRANSFORM;
            this.gT = matrix;
        }
    }

    public FlutterMutatorsStack() {
        AppMethodBeat.i(214971);
        AppMethodBeat.o(214971);
    }

    public void pushTransform(float[] fArr) {
        AppMethodBeat.i(214972);
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        a aVar = new a(matrix);
        this.mutators.add(aVar);
        this.finalMatrix.preConcat(aVar.gT);
        AppMethodBeat.o(214972);
    }

    public void pushClipRect(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(214973);
        Rect rect = new Rect(i2, i3, i4, i5);
        this.mutators.add(new a(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
        AppMethodBeat.o(214973);
    }

    public List<a> getMutators() {
        return this.mutators;
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }
}
