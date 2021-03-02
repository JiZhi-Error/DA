package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class VoiceSearchEditText extends EditText {
    final Drawable OWR = getResources().getDrawable(R.drawable.b2s);
    final Drawable OWS = null;
    final Drawable OWT = getResources().getDrawable(R.drawable.as6);
    private a OWU;
    private boolean OWV = true;
    private boolean OWW = false;
    private boolean OWX = false;
    private Context context;
    public String oxJ = "";
    private View.OnClickListener zHh;

    public interface a {
    }

    public VoiceSearchEditText(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(142460);
        init(context2);
        AppMethodBeat.o(142460);
    }

    public void setNeedIcon(boolean z) {
    }

    public VoiceSearchEditText(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(142461);
        init(context2);
        AppMethodBeat.o(142461);
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(142462);
        this.zHh = onClickListener;
        this.OWW = true;
        gLx();
        AppMethodBeat.o(142462);
    }

    public void setOnContentClearListener(a aVar) {
        this.OWU = aVar;
    }

    private void init(Context context2) {
        AppMethodBeat.i(142463);
        this.context = context2;
        this.OWW = false;
        this.OWR.setBounds(0, 0, this.OWR.getIntrinsicWidth(), this.OWR.getIntrinsicHeight());
        this.OWT.setBounds(0, 0, this.OWT.getIntrinsicWidth(), this.OWT.getIntrinsicHeight());
        gLx();
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.VoiceSearchEditText.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(142457);
                VoiceSearchEditText voiceSearchEditText = VoiceSearchEditText.this;
                if (voiceSearchEditText.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(142457);
                    return false;
                } else if (motionEvent.getAction() != 1) {
                    AppMethodBeat.o(142457);
                    return true;
                } else {
                    VoiceSearchEditText.this.OWX = true;
                    if (!VoiceSearchEditText.this.OWV || !VoiceSearchEditText.this.OWW || !voiceSearchEditText.getText().toString().equals("")) {
                        if (voiceSearchEditText.getText().toString().length() > 0) {
                            if (motionEvent.getX() > ((float) (((voiceSearchEditText.getWidth() - voiceSearchEditText.getPaddingRight()) - VoiceSearchEditText.this.OWT.getIntrinsicWidth()) - com.tencent.mm.cb.a.fromDPToPix(voiceSearchEditText.context, 25)))) {
                                voiceSearchEditText.setText("");
                                if (VoiceSearchEditText.this.OWU != null) {
                                    a unused = VoiceSearchEditText.this.OWU;
                                }
                                VoiceSearchEditText.f(VoiceSearchEditText.this);
                            } else if (!voiceSearchEditText.isFocused()) {
                                voiceSearchEditText.requestFocus();
                                if (VoiceSearchEditText.this.getContext() instanceof Activity) {
                                    MMActivity.showVKB((Activity) VoiceSearchEditText.this.getContext());
                                }
                            }
                        } else if (VoiceSearchEditText.this.zHh != null) {
                            VoiceSearchEditText.this.zHh.onClick(null);
                        }
                    } else if (motionEvent.getX() <= ((float) (((voiceSearchEditText.getWidth() - voiceSearchEditText.getPaddingRight()) - VoiceSearchEditText.this.OWR.getIntrinsicWidth()) - com.tencent.mm.cb.a.fromDPToPix(voiceSearchEditText.context, 25)))) {
                        voiceSearchEditText.requestFocus();
                        if (VoiceSearchEditText.this.getContext() instanceof Activity) {
                            MMActivity.showVKB((Activity) VoiceSearchEditText.this.getContext());
                        }
                        if (VoiceSearchEditText.this.zHh != null) {
                            VoiceSearchEditText.this.zHh.onClick(null);
                        }
                    } else if (VoiceSearchEditText.this.zHh != null) {
                        Log.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                        if (VoiceSearchEditText.this.getContext() instanceof MMActivity) {
                            ((MMActivity) VoiceSearchEditText.this.getContext()).hideVKB(voiceSearchEditText);
                        }
                        VoiceSearchEditText.this.zHh.onClick(VoiceSearchEditText.this);
                        AppMethodBeat.o(142457);
                        return true;
                    }
                    AppMethodBeat.o(142457);
                    return false;
                }
            }
        });
        addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.ui.base.VoiceSearchEditText.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(142458);
                VoiceSearchEditText.this.OWX = true;
                VoiceSearchEditText.f(VoiceSearchEditText.this);
                AppMethodBeat.o(142458);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.ui.base.VoiceSearchEditText.AnonymousClass3 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(142459);
                Log.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", Boolean.valueOf(z), Boolean.valueOf(VoiceSearchEditText.this.OWX));
                if (!z && VoiceSearchEditText.this.OWX) {
                    VoiceSearchEditText.f(VoiceSearchEditText.this);
                    VoiceSearchEditText.this.OWX = false;
                }
                AppMethodBeat.o(142459);
            }
        });
        if (context2 instanceof Activity) {
            View currentFocus = ((Activity) context2).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.OWX = false;
            } else {
                this.OWX = true;
            }
        }
        requestFocus();
        AppMethodBeat.o(142463);
    }

    private void gLx() {
        AppMethodBeat.i(142464);
        this.OWV = true;
        if (this.OWW) {
            setCompoundDrawables(this.OWS, getCompoundDrawables()[1], this.OWR, getCompoundDrawables()[3]);
            AppMethodBeat.o(142464);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.OWS, getCompoundDrawables()[1], this.OWT, getCompoundDrawables()[3]);
            AppMethodBeat.o(142464);
        } else {
            setCompoundDrawables(this.OWS, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            AppMethodBeat.o(142464);
        }
    }

    static /* synthetic */ void f(VoiceSearchEditText voiceSearchEditText) {
        AppMethodBeat.i(142465);
        Log.d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.OWW) {
            voiceSearchEditText.OWV = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.OWS, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.OWR, voiceSearchEditText.getCompoundDrawables()[3]);
            AppMethodBeat.o(142465);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.OWS, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.OWT, voiceSearchEditText.getCompoundDrawables()[3]);
            AppMethodBeat.o(142465);
        } else {
            voiceSearchEditText.OWV = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.OWS, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
            AppMethodBeat.o(142465);
        }
    }
}
