package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.writingbuddy.WritingBuddyImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SlookWritingBuddy {
    private static final String TAG = "WritingBuddy";
    public static final int TYPE_EDITOR_NUMBER = 1;
    public static final int TYPE_EDITOR_TEXT = 2;
    private ImageWritingListener mImageWritingListener;
    private View mParentView;
    private Slook mSlook = new Slook();
    private TextWritingListener mTextWritingListener;
    private WritingBuddyImpl mWritingBuddyImpl;

    public interface ImageWritingListener {
        void onImageReceived(Bitmap bitmap);
    }

    public interface TextWritingListener {
        void onTextReceived(CharSequence charSequence);
    }

    public SlookWritingBuddy(ViewGroup viewGroup) {
        AppMethodBeat.i(76237);
        if (!isSupport(1)) {
            AppMethodBeat.o(76237);
            return;
        }
        this.mParentView = viewGroup;
        this.mWritingBuddyImpl = new WritingBuddyImpl(viewGroup);
        AppMethodBeat.o(76237);
    }

    public SlookWritingBuddy(EditText editText) {
        AppMethodBeat.i(76238);
        if (!isSupport(1)) {
            AppMethodBeat.o(76238);
            return;
        }
        this.mParentView = editText;
        this.mWritingBuddyImpl = new WritingBuddyImpl(editText);
        AppMethodBeat.o(76238);
    }

    public final void setEditorType(int i2) {
        AppMethodBeat.i(76239);
        if (!isSupport(1)) {
            AppMethodBeat.o(76239);
            return;
        }
        this.mWritingBuddyImpl.setEditorType(i2);
        AppMethodBeat.o(76239);
    }

    public final int getEditorType() {
        AppMethodBeat.i(76240);
        if (!isSupport(1)) {
            AppMethodBeat.o(76240);
            return 0;
        }
        int editorType = this.mWritingBuddyImpl.getEditorType();
        AppMethodBeat.o(76240);
        return editorType;
    }

    public final void setTextWritingListener(TextWritingListener textWritingListener) {
        AppMethodBeat.i(76241);
        if (!isSupport(1)) {
            AppMethodBeat.o(76241);
            return;
        }
        this.mTextWritingListener = textWritingListener;
        this.mWritingBuddyImpl.setOnTextWritingListener(new WritingBuddyImpl.OnTextWritingListener() {
            /* class com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.AnonymousClass1 */

            public void onTextReceived(CharSequence charSequence) {
                AppMethodBeat.i(76236);
                SlookWritingBuddy.this.mTextWritingListener.onTextReceived(charSequence);
                AppMethodBeat.o(76236);
            }
        });
        AppMethodBeat.o(76241);
    }

    public final void setImageWritingListener(ImageWritingListener imageWritingListener) {
        AppMethodBeat.i(76242);
        if (!isSupport(1)) {
            AppMethodBeat.o(76242);
            return;
        }
        this.mImageWritingListener = imageWritingListener;
        if (imageWritingListener == null) {
            this.mWritingBuddyImpl.setImageWritingEnabled(false);
            this.mWritingBuddyImpl.setOnImageWritingListener((WritingBuddyImpl.OnImageWritingListener) null);
            AppMethodBeat.o(76242);
            return;
        }
        this.mWritingBuddyImpl.setImageWritingEnabled(true);
        this.mWritingBuddyImpl.setOnImageWritingListener(new WritingBuddyImpl.OnImageWritingListener() {
            /* class com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.AnonymousClass2 */

            public void onImageReceived(Bitmap bitmap) {
                AppMethodBeat.i(76235);
                SlookWritingBuddy.this.mImageWritingListener.onImageReceived(bitmap);
                AppMethodBeat.o(76235);
            }
        });
        AppMethodBeat.o(76242);
    }

    public final void setEnabled(boolean z) {
        AppMethodBeat.i(76243);
        if (!isSupport(1)) {
            AppMethodBeat.o(76243);
        } else if (this.mParentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("mParentView is null.");
            AppMethodBeat.o(76243);
            throw illegalStateException;
        } else if (this.mParentView instanceof EditText) {
            this.mParentView.setWritingBuddyEnabled(z);
            AppMethodBeat.o(76243);
        } else if (this.mParentView.getWritingBuddy(false) != null) {
            this.mParentView.setWritingBuddyEnabled(z);
            AppMethodBeat.o(76243);
        } else {
            IllegalStateException illegalStateException2 = new IllegalStateException("WritingBuddy was not enabled.");
            AppMethodBeat.o(76243);
            throw illegalStateException2;
        }
    }

    public final boolean isEnabled() {
        AppMethodBeat.i(76244);
        if (!isSupport(1)) {
            AppMethodBeat.o(76244);
            return false;
        } else if (this.mParentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("mParentView is null.");
            AppMethodBeat.o(76244);
            throw illegalStateException;
        } else {
            boolean isWritingBuddyEnabled = this.mParentView.isWritingBuddyEnabled();
            AppMethodBeat.o(76244);
            return isWritingBuddyEnabled;
        }
    }

    private boolean isSupport(int i2) {
        AppMethodBeat.i(76245);
        if (this.mSlook.isFeatureEnabled(3)) {
            AppMethodBeat.o(76245);
            return true;
        }
        AppMethodBeat.o(76245);
        return false;
    }
}
