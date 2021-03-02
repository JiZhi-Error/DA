package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class RCTCodelessLoggingEventListener {
    private static final String TAG = RCTCodelessLoggingEventListener.class.getCanonicalName();

    static {
        AppMethodBeat.i(17510);
        AppMethodBeat.o(17510);
    }

    public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding eventBinding, View view, View view2) {
        AppMethodBeat.i(17509);
        AutoLoggingOnTouchListener autoLoggingOnTouchListener = new AutoLoggingOnTouchListener(eventBinding, view, view2);
        AppMethodBeat.o(17509);
        return autoLoggingOnTouchListener;
    }

    public static class AutoLoggingOnTouchListener implements View.OnTouchListener {
        private View.OnTouchListener existingOnTouchListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging = false;

        public AutoLoggingOnTouchListener(EventBinding eventBinding, View view, View view2) {
            AppMethodBeat.i(17506);
            if (eventBinding == null || view == null || view2 == null) {
                AppMethodBeat.o(17506);
                return;
            }
            this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(view2);
            this.rootView = new WeakReference<>(view);
            this.supportCodelessLogging = true;
            AppMethodBeat.o(17506);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(17507);
            if (motionEvent.getAction() == 1) {
                logEvent();
            }
            if (this.existingOnTouchListener == null || !this.existingOnTouchListener.onTouch(view, motionEvent)) {
                AppMethodBeat.o(17507);
                return false;
            }
            AppMethodBeat.o(17507);
            return true;
        }

        private void logEvent() {
            AppMethodBeat.i(17508);
            final String eventName = this.mapping.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(this.mapping, this.rootView.get(), this.hostView.get());
            if (parameters.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
                parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
            }
            parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(17505);
                    AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                    AppMethodBeat.o(17505);
                }
            });
            AppMethodBeat.o(17508);
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }
    }
}
