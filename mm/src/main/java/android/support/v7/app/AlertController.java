package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;

final class AlertController {
    ListAdapter GO;
    CharSequence Hn;
    final e WY;
    final Window WZ;
    View XA;
    int XB = -1;
    int XC;
    int XD;
    int XE;
    int XF;
    int XG;
    int XH;
    boolean XI;
    int XJ = 0;
    final View.OnClickListener XK = new View.OnClickListener() {
        /* class android.support.v7.app.AlertController.AnonymousClass1 */

        public final void onClick(View view) {
            Message message;
            if (view == AlertController.this.Xi && AlertController.this.Xk != null) {
                message = Message.obtain(AlertController.this.Xk);
            } else if (view == AlertController.this.Xm && AlertController.this.Xo != null) {
                message = Message.obtain(AlertController.this.Xo);
            } else if (view != AlertController.this.Xq || AlertController.this.Xs == null) {
                message = null;
            } else {
                message = Message.obtain(AlertController.this.Xs);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.mHandler.obtainMessage(1, AlertController.this.WY).sendToTarget();
        }
    };
    final int Xa;
    CharSequence Xb;
    int Xc;
    int Xd;
    int Xe;
    int Xf;
    int Xg;
    boolean Xh = false;
    Button Xi;
    CharSequence Xj;
    Message Xk;
    Drawable Xl;
    Button Xm;
    CharSequence Xn;
    Message Xo;
    Drawable Xp;
    Button Xq;
    CharSequence Xr;
    Message Xs;
    Drawable Xt;
    NestedScrollView Xu;
    int Xv = 0;
    Drawable Xw;
    ImageView Xx;
    TextView Xy;
    TextView Xz;
    final Context mContext;
    Handler mHandler;
    ListView mListView;
    View mView;

    static final class b extends Handler {
        private WeakReference<DialogInterface> Yq;

        public b(DialogInterface dialogInterface) {
            this.Yq = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.Yq.get(), message.what);
                    return;
                case 0:
                default:
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
            }
        }
    }

    public AlertController(Context context, e eVar, Window window) {
        this.mContext = context;
        this.WY = eVar;
        this.WZ = window;
        this.mHandler = new b(eVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, a.C0040a.AlertDialog, R.attr.b5, 0);
        this.XC = obtainStyledAttributes.getResourceId(0, 0);
        this.XD = obtainStyledAttributes.getResourceId(2, 0);
        this.XE = obtainStyledAttributes.getResourceId(4, 0);
        this.XF = obtainStyledAttributes.getResourceId(5, 0);
        this.XG = obtainStyledAttributes.getResourceId(7, 0);
        this.XH = obtainStyledAttributes.getResourceId(3, 0);
        this.XI = obtainStyledAttributes.getBoolean(6, true);
        this.Xa = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        eVar.gR();
    }

    static boolean aZ(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (aZ(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.Hn = charSequence;
        if (this.Xy != null) {
            this.Xy.setText(charSequence);
        }
    }

    public final void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i2, onClickListener);
        }
        switch (i2) {
            case -3:
                this.Xr = charSequence;
                this.Xs = message;
                this.Xt = drawable;
                return;
            case -2:
                this.Xn = charSequence;
                this.Xo = message;
                this.Xp = drawable;
                return;
            case -1:
                this.Xj = charSequence;
                this.Xk = message;
                this.Xl = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i2) {
        this.Xw = null;
        this.Xv = i2;
        if (this.Xx == null) {
            return;
        }
        if (i2 != 0) {
            this.Xx.setVisibility(0);
            this.Xx.setImageResource(this.Xv);
            return;
        }
        this.Xx.setVisibility(8);
    }

    static ViewGroup d(View view, View view2) {
        View view3;
        View view4;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view4 = ((ViewStub) view2).inflate();
            } else {
                view4 = view2;
            }
            return (ViewGroup) view4;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view3 = ((ViewStub) view).inflate();
        } else {
            view3 = view;
        }
        return (ViewGroup) view3;
    }

    static void a(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    static void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {
        final int Yr;
        final int Ys;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.RecycleListView);
            this.Ys = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.Yr = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    public static class a {
        public ListAdapter GO;
        public CharSequence Hn;
        public Cursor To;
        public View XA;
        public int XB = -1;
        public int XO = 0;
        public CharSequence XP;
        public Drawable XQ;
        public DialogInterface.OnClickListener XR;
        public CharSequence XS;
        public Drawable XT;
        public DialogInterface.OnClickListener XU;
        public CharSequence XV;
        public Drawable XW;
        public DialogInterface.OnClickListener XX;
        public DialogInterface.OnCancelListener XY;
        public DialogInterface.OnDismissListener XZ;
        public CharSequence Xb;
        public int Xc;
        public int Xd;
        public int Xe;
        public int Xf;
        public int Xg;
        public boolean Xh = false;
        public int Xv = 0;
        public Drawable Xw;
        public DialogInterface.OnKeyListener Ya;
        public CharSequence[] Yb;
        public DialogInterface.OnClickListener Yc;
        public boolean[] Yd;
        public boolean Ye;
        public boolean Yf;
        public DialogInterface.OnMultiChoiceClickListener Yg;
        public String Yh;
        public String Yi;
        public AdapterView.OnItemSelectedListener Yj;
        public boolean Yk = true;
        public boolean mCancelable;
        public final Context mContext;
        public final LayoutInflater mInflater;
        public View mView;

        public a(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i2, CharSequence[] charSequenceArr) {
            super(context, i2, 16908308, charSequenceArr);
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }
    }
}
