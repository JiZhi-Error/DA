package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class IPCallFuncButton extends LinearLayout {
    private boolean ded = true;
    private boolean edw = false;
    private String text;
    private ImageView ywk;
    private TextView ywl;
    private Drawable ywm;
    private Drawable ywn;
    private Drawable ywo;
    private boolean ywp;
    private a ywq;
    private View.OnTouchListener ywr = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(25798);
            if (!IPCallFuncButton.this.ded) {
                AppMethodBeat.o(25798);
            } else {
                if (motionEvent.getAction() == 0) {
                    if (IPCallFuncButton.this.ywp) {
                        if (IPCallFuncButton.this.edw) {
                            IPCallFuncButton.this.ywk.setImageDrawable(IPCallFuncButton.this.ywm);
                            IPCallFuncButton.this.edw = false;
                        } else {
                            IPCallFuncButton.this.ywk.setImageDrawable(IPCallFuncButton.this.ywn);
                            IPCallFuncButton.this.edw = true;
                        }
                        if (IPCallFuncButton.this.ywq != null) {
                            IPCallFuncButton.this.ywq.qA(IPCallFuncButton.this.edw);
                        }
                    } else if (IPCallFuncButton.this.ywn != null) {
                        IPCallFuncButton.this.ywk.setImageDrawable(IPCallFuncButton.this.ywn);
                    }
                } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !IPCallFuncButton.this.ywp) {
                    if (IPCallFuncButton.this.ywm != null) {
                        IPCallFuncButton.this.ywk.setImageDrawable(IPCallFuncButton.this.ywm);
                    }
                    if (IPCallFuncButton.this.ywq != null) {
                        IPCallFuncButton.this.ywq.qA(false);
                    }
                }
                AppMethodBeat.o(25798);
            }
            return false;
        }
    };

    public interface a {
        void qA(boolean z);
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25799);
        LayoutInflater.from(getContext()).inflate(R.layout.awo, this);
        this.ywk = (ImageView) findViewById(R.id.agf);
        this.ywl = (TextView) findViewById(R.id.ijq);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.a.IPCallFuncButton, 0, 0);
        this.ywm = obtainStyledAttributes.getDrawable(2);
        this.ywn = obtainStyledAttributes.getDrawable(3);
        this.ywp = obtainStyledAttributes.getBoolean(0, false);
        this.ywo = obtainStyledAttributes.getDrawable(1);
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (!Util.isNullOrNil(this.text)) {
            this.ywl.setText(this.text);
        } else {
            this.ywl.setVisibility(8);
        }
        if (this.ywm != null) {
            this.ywk.setImageDrawable(this.ywm);
        }
        this.ywk.setClickable(true);
        this.ywk.setOnTouchListener(this.ywr);
        AppMethodBeat.o(25799);
    }

    public void setClickCallback(a aVar) {
        this.ywq = aVar;
    }

    public String getFuncText() {
        return this.text;
    }

    public void setFuncText(String str) {
        AppMethodBeat.i(25800);
        this.text = str;
        this.ywl.setText(this.text);
        AppMethodBeat.o(25800);
    }

    public final boolean isChecked() {
        if (this.ywp) {
            return this.edw;
        }
        return false;
    }

    public void setCheckBoxMode(boolean z) {
        AppMethodBeat.i(25801);
        if (this.ywp != z) {
            this.ywp = z;
            this.edw = false;
            if (this.ywm != null) {
                this.ywk.setImageDrawable(this.ywm);
            }
        }
        AppMethodBeat.o(25801);
    }

    public void setEnable(boolean z) {
        AppMethodBeat.i(25802);
        if (z != this.ded) {
            this.ded = z;
            if (this.ded || this.ywo == null) {
                this.ywk.setImageDrawable(this.ywm);
            } else {
                this.ywk.setImageDrawable(this.ywo);
            }
            this.edw = false;
        }
        AppMethodBeat.o(25802);
    }

    public void setChecked(boolean z) {
        AppMethodBeat.i(25803);
        if (z != this.edw && this.ywp) {
            this.edw = z;
            if (this.edw) {
                this.ywk.setImageDrawable(this.ywn);
                AppMethodBeat.o(25803);
                return;
            }
            this.ywk.setImageDrawable(this.ywm);
        }
        AppMethodBeat.o(25803);
    }
}
