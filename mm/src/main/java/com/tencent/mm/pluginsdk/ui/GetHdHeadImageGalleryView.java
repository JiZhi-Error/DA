package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.s;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    private String CZs;
    private p KbQ;
    private Bitmap KbR;
    private Bitmap KbS;
    private a KbT;
    private String username;

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(152133);
        init();
        AppMethodBeat.o(152133);
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(152134);
        init();
        AppMethodBeat.o(152134);
    }

    private void init() {
        AppMethodBeat.i(152135);
        this.KbT = new a(this, (byte) 0);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter((SpinnerAdapter) this.KbT);
        setSelection(0);
        setSingleClickOverListener(new c(this, (byte) 0));
        setLongClickOverListener(new b(this, (byte) 0));
        AppMethodBeat.o(152135);
    }

    public void setParentWindow(p pVar) {
        this.KbQ = pVar;
    }

    public void setHdHeadImagePath(String str) {
        this.CZs = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setThumbImage(Bitmap bitmap) {
        AppMethodBeat.i(152136);
        this.KbR = bitmap;
        this.KbT.notifyDataSetChanged();
        AppMethodBeat.o(152136);
    }

    public void setHdHeadImage(Bitmap bitmap) {
        AppMethodBeat.i(152137);
        this.KbS = bitmap;
        this.KbT.notifyDataSetChanged();
        AppMethodBeat.o(152137);
    }

    /* access modifiers changed from: package-private */
    public class c implements MMGestureGallery.f {
        private c() {
        }

        /* synthetic */ c(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.f
        public final void bmt() {
            AppMethodBeat.i(152132);
            if (GetHdHeadImageGalleryView.this.KbQ != null) {
                GetHdHeadImageGalleryView.this.KbQ.dismiss();
            }
            AppMethodBeat.o(152132);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements MMGestureGallery.c {
        private b() {
        }

        /* synthetic */ b(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b2) {
            this();
        }

        @Override // com.tencent.mm.ui.tools.MMGestureGallery.c
        public final void bmu() {
            AppMethodBeat.i(152131);
            if (!(GetHdHeadImageGalleryView.this.CZs == null || GetHdHeadImageGalleryView.this.username == null)) {
                h.a(GetHdHeadImageGalleryView.this.getContext(), (String) null, GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(R.array.m), "", new h.d() {
                    /* class com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.b.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(152130);
                        switch (i2) {
                            case 0:
                                com.tencent.mm.platformtools.p.a(GetHdHeadImageGalleryView.this.getContext(), new Runnable() {
                                    /* class com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.b.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(223845);
                                        String str = AndroidMediaUtil.getSysCameraDirPath() + "hdImg_" + g.getMessageDigest(GetHdHeadImageGalleryView.this.username.getBytes()) + System.currentTimeMillis() + ".jpg";
                                        s.deleteFile(str);
                                        s.nw(GetHdHeadImageGalleryView.this.CZs, str);
                                        AndroidMediaUtil.refreshMediaScanner(str, GetHdHeadImageGalleryView.this.getContext());
                                        Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(R.string.dv7, AndroidMediaUtil.getSysCameraDirPath()), 1).show();
                                        AppMethodBeat.o(223845);
                                    }
                                }, new Runnable() {
                                    /* class com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.b.AnonymousClass1.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(223846);
                                        Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(R.string.gao), 1).show();
                                        AppMethodBeat.o(223846);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(152130);
                    }
                });
            }
            AppMethodBeat.o(152131);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b2) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(152128);
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(152128);
            return valueOf;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2023a aVar;
            AppMethodBeat.i(152129);
            if (view == null) {
                C2023a aVar2 = new C2023a();
                view = View.inflate(GetHdHeadImageGalleryView.this.getContext(), R.layout.c5w, null);
                aVar2.FLW = (ProgressBar) view.findViewById(R.id.dng);
                aVar2.dPk = (ImageView) view.findViewById(R.id.dnf);
                aVar2.JPl = view.findViewById(R.id.dnh);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C2023a) view.getTag();
            }
            view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            if (GetHdHeadImageGalleryView.this.KbS != null) {
                aVar.FLW.setVisibility(8);
                aVar.dPk.setVisibility(8);
                aVar.JPl.setVisibility(8);
                MultiTouchImageView multiTouchImageView = new MultiTouchImageView(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.KbS.getWidth(), GetHdHeadImageGalleryView.this.KbS.getHeight(), (byte) 0);
                multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                multiTouchImageView.setImageBitmap(GetHdHeadImageGalleryView.this.KbS);
                multiTouchImageView.setMaxZoomLimit(2.0f);
                multiTouchImageView.setMaxZoomDoubleTab(true);
                AppMethodBeat.o(152129);
                return multiTouchImageView;
            }
            aVar.FLW.setVisibility(0);
            aVar.JPl.setVisibility(0);
            if (GetHdHeadImageGalleryView.this.KbR != null) {
                aVar.dPk.setVisibility(0);
                aVar.dPk.setImageBitmap(GetHdHeadImageGalleryView.this.KbR);
            } else {
                aVar.dPk.setVisibility(8);
            }
            AppMethodBeat.o(152129);
            return view;
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView$a$a  reason: collision with other inner class name */
        class C2023a {
            ProgressBar FLW;
            View JPl;
            ImageView dPk;

            C2023a() {
            }
        }
    }
}
