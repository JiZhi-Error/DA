package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.tools.MaskImageButton;
import junit.framework.Assert;

public class a extends j implements e.a {
    public static float ppN = 0.1f;
    protected boolean pressed;

    /* renamed from: com.tencent.mm.pluginsdk.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC2024a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    /* synthetic */ a(String str, byte b2) {
        this(str);
    }

    public a(j.a aVar, String str) {
        super(aVar, str);
    }

    @Override // com.tencent.mm.aj.e.a, com.tencent.mm.pluginsdk.ui.j
    public void Mr(String str) {
        AppMethodBeat.i(152110);
        super.Mr(str);
        AppMethodBeat.o(152110);
    }

    public final void setIsPressed(boolean z) {
        this.pressed = z;
    }

    public static class b {
        public static j.a Boe;

        public static j.a gov() {
            AppMethodBeat.i(152101);
            Assert.assertTrue(Boe != null);
            j.a aVar = Boe;
            AppMethodBeat.o(152101);
            return aVar;
        }

        public static void c(ImageView imageView, String str) {
            AppMethodBeat.i(152102);
            if (imageView == null) {
                Log.e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.o(152102);
                return;
            }
            a(imageView, str, a.ppN, false);
            AppMethodBeat.o(152102);
        }

        public static void y(ImageView imageView, String str) {
            a aVar;
            AppMethodBeat.i(223827);
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                aVar = new a(str, (byte) 0);
                aVar.zO(true);
            } else {
                aVar = (a) drawable;
            }
            aVar.setTag(str);
            imageView.setImageDrawable(aVar);
            imageView.invalidate();
            B(imageView, str);
            AppMethodBeat.o(223827);
        }

        public static void d(ImageView imageView, String str) {
            AppMethodBeat.i(152103);
            a(imageView, str, 0.5f, false);
            AppMethodBeat.o(152103);
        }

        public static void d(ImageView imageView, String str, float f2) {
            AppMethodBeat.i(263524);
            a(imageView, str, f2, false);
            AppMethodBeat.o(263524);
        }

        public static void z(ImageView imageView, String str) {
            AppMethodBeat.i(152105);
            a(imageView, str, 0.5f, true);
            AppMethodBeat.o(152105);
        }

        public static void a(ImageView imageView, String str, float f2, boolean z) {
            c cVar;
            AppMethodBeat.i(152106);
            if (imageView == null) {
                Log.e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.o(152106);
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof c)) {
                cVar = new c(str, f2);
                cVar.zO(z);
            } else {
                cVar = (c) drawable;
            }
            cVar.setTag(str);
            imageView.setImageDrawable(cVar);
            imageView.invalidate();
            B(imageView, str);
            n(imageView);
            AppMethodBeat.o(152106);
        }

        public static void A(ImageView imageView, String str) {
            AppMethodBeat.i(152107);
            if (imageView == null) {
                Log.e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.o(152107);
                return;
            }
            a(imageView, str, a.ppN, false);
            AppMethodBeat.o(152107);
        }

        public static void a(ImageView imageView, String str, com.tencent.mm.aj.b bVar) {
            d dVar;
            AppMethodBeat.i(223829);
            if (imageView == null) {
                AppMethodBeat.o(223829);
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof d)) {
                dVar = new d(str);
            } else {
                dVar = (d) drawable;
            }
            if (dVar.Kbi != null) {
                dVar.Kbi.Kbk = bVar;
            }
            if (dVar.Kbj != R.drawable.bam || dVar.Kbi == null || dVar.Kbi.pqA == null || dVar.Kbi.pqA.isRecycled()) {
                dVar.Kbj = R.drawable.bam;
                Bitmap bitmapNative = BitmapUtil.getBitmapNative((int) R.drawable.bam);
                if (dVar.Kbi != null) {
                    d.a aVar = dVar.Kbi;
                    aVar.pqA = bitmapNative;
                    aVar.pqA = aVar.aJ(aVar.pqA);
                }
            }
            dVar.setTag(str);
            imageView.setImageDrawable(dVar);
            imageView.invalidate();
            B(imageView, str);
            AppMethodBeat.o(223829);
        }

        private static void B(final ImageView imageView, final String str) {
            AppMethodBeat.i(152109);
            if (WeChatEnvironment.hasDebugger() && imageView != null && !imageView.isLongClickable() && !(imageView instanceof NotCopyUserNameImageView)) {
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.a.b.AnonymousClass1 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(152099);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        ClipboardHelper.setText(imageView.getContext(), "UserName:", str);
                        Toast.makeText(imageView.getContext(), (int) R.string.ta, 0).show();
                        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(152099);
                        return true;
                    }
                });
                if (!imageView.isClickable()) {
                    imageView.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.pluginsdk.ui.a.b.AnonymousClass2 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(152100);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            View view2 = (View) view.getParent();
                            while (true) {
                                if (view2 == null) {
                                    break;
                                } else if (!view2.isClickable()) {
                                    view2 = view2.getParent() instanceof View ? (View) view2.getParent() : null;
                                } else if (view2 instanceof AdapterView) {
                                    Object tag = imageView.getTag();
                                    if (tag instanceof Integer) {
                                        ((AdapterView) view2).performItemClick(null, ((Integer) tag).intValue(), -1);
                                    }
                                } else {
                                    view2.performClick();
                                }
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/AvatarDrawable$Factory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(152100);
                        }
                    });
                }
            }
            AppMethodBeat.o(152109);
        }

        private static void n(final ImageView imageView) {
            AppMethodBeat.i(223830);
            if (imageView != null && !(imageView instanceof MaskImageButton) && (imageView.isClickable() || imageView.isLongClickable())) {
                try {
                    imageView.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.tencent.mm.pluginsdk.ui.a.b.AnonymousClass3 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.i(223826);
                            int actionMasked = motionEvent.getActionMasked();
                            Log.d("MicroMsg.AvatarDrawable", "touch view %s, event %s", view, Integer.valueOf(actionMasked));
                            if (actionMasked == 0) {
                                if (imageView.getDrawable() != null && (imageView.getDrawable() instanceof a)) {
                                    ((a) imageView.getDrawable()).setIsPressed(true);
                                    imageView.invalidate();
                                }
                            } else if ((actionMasked == 1 || actionMasked == 3) && imageView.getDrawable() != null && (imageView.getDrawable() instanceof a)) {
                                ((a) imageView.getDrawable()).setIsPressed(false);
                                imageView.invalidate();
                            }
                            AppMethodBeat.o(223826);
                            return false;
                        }
                    });
                    AppMethodBeat.o(223830);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AvatarDrawable", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(223830);
        }
    }

    private a(String str) {
        super(b.Boe, str);
    }
}
