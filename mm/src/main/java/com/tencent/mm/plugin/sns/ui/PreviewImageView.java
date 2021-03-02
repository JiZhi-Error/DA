package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class PreviewImageView extends LinearLayout implements z {
    private TableLayout EuT;
    private final Map<Integer, View> EuU = new HashMap();
    private final Map<Integer, TableRow> EuV = new HashMap();
    private final int EuW = 4;
    private HashMap<String, Bitmap> EuX = new HashMap<>();
    private z.a EuY;
    private boolean EuZ = true;
    private boolean Eva = false;
    private final Context context;
    private List<String> list = new ArrayList();

    public PreviewImageView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(98197);
        this.context = context2;
        init();
        AppMethodBeat.o(98197);
    }

    public PreviewImageView(Context context2) {
        super(context2);
        AppMethodBeat.i(98198);
        this.context = context2;
        init();
        AppMethodBeat.o(98198);
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public void setIsShowAddImage(boolean z) {
        this.EuZ = z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public void setImageClick(z.a aVar) {
        this.EuY = aVar;
    }

    private void init() {
        AppMethodBeat.i(98199);
        this.EuT = (TableLayout) LayoutInflater.from(this.context).inflate(R.layout.bwx, (ViewGroup) this, true).findViewById(R.id.be9);
        fgJ();
        AppMethodBeat.o(98199);
    }

    private void fgJ() {
        AppMethodBeat.i(98200);
        if (this.context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Point point = new Point();
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
            aj.k(point);
        }
        AppMethodBeat.o(98200);
    }

    public int getCount() {
        AppMethodBeat.i(98201);
        int size = this.EuU.size();
        AppMethodBeat.o(98201);
        return size;
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final void clean() {
        AppMethodBeat.i(98202);
        this.Eva = true;
        for (Bitmap bitmap : this.EuX.values()) {
            if (r.M(bitmap)) {
                bitmap.recycle();
            }
        }
        AppMethodBeat.o(98202);
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final void setList$22875ea3(List<String> list2) {
        TableRow tableRow;
        int i2;
        String str;
        AppMethodBeat.i(98203);
        long currentTimeMillis = System.currentTimeMillis();
        if (list2 == null) {
            AppMethodBeat.o(98203);
            return;
        }
        this.list = list2;
        int i3 = 0;
        this.EuT.removeAllViews();
        int size = list2.size() + 1;
        int i4 = 0;
        while (i3 < size) {
            TableRow tableRow2 = this.EuV.get(Integer.valueOf(i4));
            if (tableRow2 == null) {
                TableRow tableRow3 = new TableRow(this.context);
                this.EuV.put(Integer.valueOf(i4), tableRow3);
                tableRow = tableRow3;
            } else {
                tableRow = tableRow2;
            }
            tableRow.removeAllViews();
            int i5 = 0;
            while (true) {
                if (i5 >= 4 || i3 >= size) {
                    i2 = i3;
                } else if (i3 >= 9) {
                    i2 = i3 + 1;
                    break;
                } else {
                    View view = this.EuU.get(Integer.valueOf(i3));
                    if (view == null) {
                        view = View.inflate(this.context, R.layout.bwy, null);
                        this.EuU.put(Integer.valueOf(i3), view);
                    }
                    if (i3 == size - 1) {
                        str = "";
                    } else {
                        str = list2.get(i3);
                    }
                    ImageView imageView = (ImageView) view.findViewById(R.id.e44);
                    if (i3 != size - 1) {
                        imageView.setBackgroundDrawable(null);
                        imageView.setTag(str);
                        imageView.setContentDescription(getContext().getString(R.string.h71));
                        Bitmap bitmap = this.EuX.get(str);
                        if (!r.M(bitmap)) {
                            Log.d("MicroMsg.PreviewImageView", "bm is null");
                            new a(imageView, str).y("");
                        } else {
                            imageView.setImageBitmap(bitmap);
                        }
                    } else if (this.EuZ) {
                        imageView.setBackgroundResource(R.drawable.aut);
                        imageView.setContentDescription(getContext().getString(R.string.h4w));
                        imageView.setImageDrawable(null);
                    } else {
                        i5++;
                        i3++;
                    }
                    if (this.EuY != null) {
                        if (i3 == size - 1) {
                            view.setTag(-1);
                            view.setOnClickListener(this.EuY.Erh);
                            view.setClickable(true);
                        } else {
                            view.setTag(Integer.valueOf(i3));
                            view.setOnClickListener(this.EuY.Erh);
                            view.setClickable(true);
                        }
                    }
                    view.setLayoutParams(new TableRow.LayoutParams(-2, -2));
                    tableRow.addView(view);
                    i5++;
                    i3++;
                }
            }
            if (tableRow.getChildCount() > 0) {
                this.EuT.addView(tableRow);
            }
            Log.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
            i4++;
            i3 = i2;
        }
        AppMethodBeat.o(98203);
    }

    class a extends h<String, Integer, Boolean> {
        private ImageView dPk;
        private Bitmap iKs;
        private String path;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            AppMethodBeat.i(98195);
            super.onPostExecute(bool);
            if (!PreviewImageView.this.Eva && r.M(this.iKs)) {
                PreviewImageView.this.EuX.put(this.path, this.iKs);
                if (this.dPk.getTag() != null && (this.dPk.getTag() instanceof String) && this.dPk.getTag().equals(this.path)) {
                    this.dPk.setImageBitmap(this.iKs);
                }
            }
            AppMethodBeat.o(98195);
        }

        public a(ImageView imageView, String str) {
            this.dPk = imageView;
            this.path = str;
        }

        @Override // com.tencent.mm.plugin.sns.model.h
        public final ExecutorService eGk() {
            AppMethodBeat.i(179158);
            ExecutorService fay = aj.fay();
            AppMethodBeat.o(179158);
            return fay;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ Boolean doInBackground(String[] strArr) {
            AppMethodBeat.i(259453);
            if (PreviewImageView.this.Eva) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(259453);
                return bool;
            }
            this.iKs = BitmapUtil.extractThumbNail(this.path, aj.fbb(), aj.fbb(), true);
            int orientationInDegree = Exif.fromFile(this.path).getOrientationInDegree();
            Log.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(orientationInDegree));
            this.iKs = BitmapUtil.rotate(this.iKs, (float) orientationInDegree);
            Boolean bool2 = Boolean.TRUE;
            AppMethodBeat.o(259453);
            return bool2;
        }
    }
}
