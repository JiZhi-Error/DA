package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.analyzer.model.d;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;

public enum c {
    ACTIVITY_CLIENT_RECORD__NEXT_IDLE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 >= 19 && i2 <= 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.app.ActivityThread$ActivityClientRecord", "nextIdle").eO("Android AOSP sometimes keeps a reference to a destroyed activity as a nextIdle client record in the android.app.ActivityThread.mActivities map. Not sure what's going on there, input welcome.");
        }
    },
    SPAN_CONTROLLER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.widget.Editor$EasyEditSpanController", "this$0").eO("Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.");
            aVar.L("android.widget.Editor$SpanController", "this$0").eO("Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.");
        }
    },
    MEDIA_SESSION_LEGACY_HELPER__SINSTANCE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 == 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.media.session.MediaSessionLegacyHelper", "sInstance").eO("MediaSessionLegacyHelper is a static singleton that is lazily instantiated and keeps a reference to the context it's given the first time MediaSessionLegacyHelper.getHelper() is called. This leak was introduced in android-5.0.1_r1 and fixed in Android 5.1.0_r1 by calling context.getApplicationContext(). Fix: https://github.com/android/platform_frameworks_base/commit/9b5257c9c99c4cb541d8e8e78fb04f008b1a9091 To fix this, you could call MediaSessionLegacyHelper.getHelper() early in Application.onCreate() and pass it the application context.");
        }
    },
    TEXT_LINE__SCACHED {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.text.TextLine", "sCached").eO("TextLine.sCached is a pool of 3 TextLine instances. TextLine.recycle() has had at least two bugs that created memory leaks by not correctly clearing the recycled TextLine instances. The first was fixed in android-5.1.0_r1: https://github.com/android/platform_frameworks_base/commit/893d6fe48d37f71e683f722457bea646994a10 The second was fixed, not released yet: https://github.com/android/platform_frameworks_base/commit/b3a9bc038d3a218b1dbdf7b5668e3d6c12be5e To fix this, you could access TextLine.sCached and clear the pool every now and then (e.g. on activity destroy).");
        }
    },
    BLOCKING_QUEUE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.os.Message", "obj").eO("Prior to ART, a thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after beingused, this won't be a problem, because these references are cleared when beingrecycled. However, dialogs create template Message instances to be copied when amessage needs to be sent. These Message templates holds references to the dialoglisteners, which most likely leads to holding a reference onto the activity in someway. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a librarythat is widely used should consider doing this for its own handler threads.");
            aVar.L("android.os.Message", "next").eO("Prior to ART, a thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after beingused, this won't be a problem, because these references are cleared when beingrecycled. However, dialogs create template Message instances to be copied when amessage needs to be sent. These Message templates holds references to the dialoglisteners, which most likely leads to holding a reference onto the activity in someway. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a librarythat is widely used should consider doing this for its own handler threads.");
            aVar.L("android.os.Message", "target").eO("Prior to ART, a thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after beingused, this won't be a problem, because these references are cleared when beingrecycled. However, dialogs create template Message instances to be copied when amessage needs to be sent. These Message templates holds references to the dialoglisteners, which most likely leads to holding a reference onto the activity in someway. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a librarythat is widely used should consider doing this for its own handler threads.");
        }
    },
    INPUT_METHOD_MANAGER__SERVED_VIEW {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 >= 15 && i2 <= 26;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.view.inputmethod.InputMethodManager", "mNextServedView").eO("When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414");
            aVar.L("android.view.inputmethod.InputMethodManager", "mServedView").eO("When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414");
            aVar.L("android.view.inputmethod.InputMethodManager", "mServedInputConnection").eO("When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414");
        }
    },
    INPUT_METHOD_MANAGER__ROOT_VIEW {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 >= 15 && i2 <= 23;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.view.inputmethod.InputMethodManager", "mCurRootView").eO("The singleton InputMethodManager is holding a reference to mCurRootView long after the activity has been destroyed. Observed on ICS MR1: https://github.com/square/leakcanary/issues/1#issuecomment-100579429 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414");
        }
    },
    LAYOUT_TRANSITION {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 >= 14 && i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.animation.LayoutTransition$1", "val$parent").eO("LayoutTransition leaks parent ViewGroup through ViewTreeObserver.OnPreDrawListener When triggered, this leaks stays until the window is destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=171830");
        }
    },
    SPELL_CHECKER_SESSION {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return (i2 >= 16 && i2 <= 22) || i2 >= 24;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.view.textservice.SpellCheckerSession$1", "this$0").eO("SpellCheckerSessionListenerImpl.mHandler is leaking destroyed Activity when the SpellCheckerSession is closed before the service is connected. Tracked here: https://code.google.com/p/android/issues/detail?id=172542");
        }
    },
    ACTIVITY_CHOOSE_MODEL {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 > 14 && i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.support.v7.internal.widget.ActivityChooserModel", "mActivityChoserModelPolicy").eO("ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0");
            aVar.L("android.widget.ActivityChooserModel", "mActivityChoserModelPolicy").eO("ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0");
        }
    },
    SPEECH_RECOGNIZER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 < 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.speech.SpeechRecognizer$InternalListener", "this$0").eO("Prior to Android 5, SpeechRecognizer.InternalListener was a non static inner class and leaked the SpeechRecognizer which leaked an activity context. Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit /b37866db469e81aca534ff6186bdafd44352329b");
        }
    },
    ACCOUNT_MANAGER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.accounts.AccountManager$AmsTask$Response", "this$1").eO("AccountManager$AmsTask$Response is a stub and is held in memory by native code, probably because the reference to the response in the other process hasn't been cleared. AccountManager$AmsTask is holding on to the activity reference to use for launching a new sub- Activity. Tracked here: https://code.google.com/p/android/issues/detail?id=173689 Fix: Pass a null activity reference to the AccountManager methods and then deal with the returned future to to get the result and correctly start an activity when it's available.");
        }
    },
    MEDIA_SCANNER_CONNECTION {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.media.MediaScannerConnection", "mContext").eO("The static method MediaScannerConnection.scanFile() takes an activity context but the service might not disconnect after the activity has been destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=173788 Fix: Create an instance of MediaScannerConnection yourself and pass in the application context. Call connect() and disconnect() manually.");
        }
    },
    USER_MANAGER__SINSTANCE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 >= 16 && i2 <= 23;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.os.UserManager", "mContext").eO("UserManager has a static sInstance field that creates an instance and caches it the first time UserManager.get() is called. This instance is created with the outer context (which is an activity base context). Tracked here: https://code.google.com/p/android/issues/detail?id=173789 Introduced by: https://github.com/android/platform_frameworks_base/commit/27db46850b708070452c0ce49daf5f79503fbde6 Fix: trigger a call to UserManager.get() in Application.onCreate(), so that the UserManager instance gets cached with a reference to the application context.");
        }
    },
    APP_WIDGET_HOST_CALLBACKS {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 < 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.appwidget.AppWidgetHost$Callbacks", "this$0").eO("android.appwidget.AppWidgetHost$Callbacks is a stub and is held in memory native code. The reference to the `mContext` was not being cleared, which caused the Callbacks instance to retain this reference Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit/7a96f3c917e0001ee739b65da37b2fadec7d7765");
        }
    },
    AUDIO_MANAGER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.media.AudioManager$1", "this$0").eO("Prior to Android M, VideoView required audio focus from AudioManager and never abandoned it, which leaks the Activity context through the AudioManager. The root of the problem is that AudioManager uses whichever context it receives, which in the case of the VideoView example is an Activity, even though it only needs the application's context. The issue is fixed in Android M, and the AudioManager now uses the application's context. Tracked here: https://code.google.com/p/android/issues/detail?id=152173 Fix: https://gist.github.com/jankovd/891d96f476f7a9ce24e2");
        }
    },
    EDITTEXT_BLINK_MESSAGEQUEUE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.widget.Editor$Blink", "this$0").eO("The EditText Blink of the Cursor is implemented using a callback and Messages, which trigger the display of the Cursor. If an AlertDialog or DialogFragment that contains a blinking cursor is detached, a message is posted with a delay after the dialog has been closed and as a result leaks the Activity. This can be fixed manually by calling TextView.setCursorVisible(false) in the dismiss() method of the dialog. Tracked here: https://code.google.com/p/android/issues/detail?id=188551 Fixed in AOSP: https://android.googlesource.com/platform/frameworks/base/+/5b734f2430e9f26c769d6af8ea5645e390fcf5af%5E%21/");
        }
    },
    CONNECTIVITY_MANAGER__SINSTANCE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return i2 <= 23;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.net.ConnectivityManager", "sInstance").eO("ConnectivityManager has a sInstance field that is set when the firstConnectivityManager instance is created. ConnectivityManager has a mContext field.When calling activity.getSystemService(Context.CONNECTIVITY_SERVICE) , the firstConnectivityManager instance is created with the activity context and stored insInstance. That activity context then leaks forever.Until this is fixed, app developers can prevent this leak by making sure the ConnectivityManager is first created with an App Context. E.g. in some static init do: context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) Tracked here: https://code.google.com/p/android/issues/detail?id=198852 Introduced here: https://github.com/android/platform_frameworks_base/commit/e0bef71662d81caaaa0d7214fb0bef5d39996a69");
        }
    },
    INSTRUMENTATION_RECOMMEND_ACTIVITY {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "Meizu".equals(str) && i2 >= 21 && i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.app.Instrumentation", "mRecommendActivity").eO("Instrumentation would leak com.android.internal.app.RecommendActivity (in framework.jar) in Meizu FlymeOS 4.5 and above, which is based on Android 5.0 and above");
        }
    },
    DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "motorola".equals(str) && i2 >= 19 && i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.app.admin.DevicePolicyManager$SettingsObserver", "this$0").eO("DevicePolicyManager keeps a reference to the context it has been created with instead of extracting the application context. In this Motorola build, DevicePolicyManager has an inner SettingsObserver class that is a content observer, which is held into memory by a binder transport object.");
        }
    },
    SPEN_GESTURE_MANAGER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("com.samsung.android.smartclip.SpenGestureManager", "mContext").eO("SpenGestureManager has a static mContext field that leaks a reference to the activity. Yes, a STATIC mContext field.");
        }
    },
    GESTURE_BOOST_MANAGER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "HUAWEI".equals(str) && i2 >= 24 && i2 <= 26;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.gestureboost.GestureBoostManager", "mContext").eO("GestureBoostManager is a static singleton that leaks an activity context.Fix: https://github.com/square/leakcanary/issues/696#issuecomment-296420756");
        }
    },
    CLIPBOARD_UI_MANAGER__SINSTANCE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 >= 19 && i2 <= 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.sec.clipboard.ClipboardUIManager", "mContext").eO("ClipboardUIManager is a static singleton that leaks an activity context. Fix: trigger a call to ClipboardUIManager.getInstance() in Application.onCreate() , so that the ClipboardUIManager instance gets cached with a reference to the application context. Example: https://gist.github.com/cypressious/91c4fb1455470d803a602838dfcd5774");
        }
    },
    SEM_CLIPBOARD_MANAGER__MCONTEXT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 >= 19 && i2 <= 24;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("com.samsung.android.content.clipboard.SemClipboardManager", "mContext").eO("SemClipboardManager is held in memory by an anonymous inner class implementation of android.os.Binder, thereby leaking an activity context.");
        }
    },
    SEM_EMERGENCY_MANAGER__MCONTEXT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 >= 19 && i2 <= 24;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("com.samsung.android.emergencymode.SemEmergencyManager", "mContext").eO("SemEmergencyManager is a static singleton that leaks a DecorContext.");
        }
    },
    BUBBLE_POPUP_HELPER__SHELPER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "LGE".equals(str) && i2 >= 19 && i2 <= 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.widget.BubblePopupHelper", "sHelper").eO("A static helper for EditText bubble popups leaks a reference to the latestfocused view.");
        }
    },
    LGCONTEXT__MCONTEXT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "LGE".equals(str) && i2 == 21;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("com.lge.systemservice.core.LGContext", "mContext").eO("LGContext is a static singleton that leaks an activity context.");
        }
    },
    AW_RESOURCE__SRESOURCES {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("com.android.org.chromium.android_webview.AwResource", "sResources");
        }
    },
    MAPPER_CLIENT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "NVIDIA".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("com.nvidia.ControllerMapper.MapperClient$ServiceClient", "this$0").eO("Not sure exactly what ControllerMapper is about, but there is an anonymous HeapDumpHandler in ControllerMapper.MapperClient.ServiceClient, which leaks ControllerMapper.MapperClient which leaks the activity context.");
        }
    },
    TEXT_VIEW__MLAST_HOVERED_VIEW {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 >= 19 && i2 <= 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.widget.TextView", "mLastHoveredView").eO("mLastHoveredView is a static field in TextView that leaks the last hovered view.");
        }
    },
    PERSONA_MANAGER {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.os.PersonaManager", "mContext").eO("android.app.LoadedApk.mResources has a reference to android.content.res.Resources.mPersonaManager which has a reference to android.os.PersonaManager.mContext which is an activity.");
        }
    },
    RESOURCES__MCONTEXT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.content.res.Resources", "mContext").eO("In AOSP the Resources class does not have a context. Here we have ZygoteInit.mResources (static field) holding on to a Resources instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issue-74450184");
        }
    },
    VIEW_CONFIGURATION__MCONTEXT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.view.ViewConfiguration", "mContext").eO("In AOSP the ViewConfiguration class does not have a context. Here we have ViewConfiguration.sConfigurations (static field) holding on to a ViewConfiguration instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issuecomment-100324683");
        }
    },
    SYSTEM_SENSOR_MANAGER_LENOVO {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "LENOVO".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.hardware.SystemSensorManager", "mAppContextImpl").eO("Lenovo specific leak. SystemSensorManager stores a reference to context in a static field in its constructor. Found on LENOVO 4.4.2. Fix: use application context to get SensorManager");
        }
    },
    AUDIO_MANAGER__MCONTEXT_STATIC {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 19;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.media.AudioManager", "mContext_static").eO("Samsung added a static mContext_static field to AudioManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/32");
        }
    },
    ACTIVITY_MANAGER_MCONTEXT {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final boolean n(int i2, String str) {
            return "samsung".equals(str) && i2 == 22;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.M("android.app.ActivityManager", "mContext").eO("Samsung added a static mContext field to ActivityManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/177 Fix in comment: https://github.com/square/leakcanary/issues/177#issuecomment-222724283");
        }
    },
    SOFT_REFERENCES {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.eM(WeakReference.class.getName()).SZ();
            aVar.eM(SoftReference.class.getName()).SZ();
            aVar.eM(PhantomReference.class.getName()).SZ();
            aVar.eM("java.lang.ref.Finalizer").SZ();
            aVar.eM("java.lang.ref.FinalizerReference").SZ();
        }
    },
    FINALIZER_WATCHDOG_DAEMON {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.eL("FinalizerWatchdogDaemon").SZ();
        }
    },
    MAIN {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.eL("main").SZ();
        }
    },
    EVENT_RECEIVER__MMESSAGE_QUEUE {
        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.analyzer.model.c
        public final void a(d.a aVar) {
            aVar.L("android.view.Choreographer$FrameDisplayEventReceiver", "mMessageQueue").SZ();
        }
    };

    /* access modifiers changed from: package-private */
    public abstract void a(d.a aVar);

    /* synthetic */ c(byte b2) {
        this();
    }

    public static d.a l(int i2, String str) {
        return a(EnumSet.of(SOFT_REFERENCES, FINALIZER_WATCHDOG_DAEMON, MAIN, EVENT_RECEIVER__MMESSAGE_QUEUE), i2, str);
    }

    public static d.a m(int i2, String str) {
        return a(EnumSet.allOf(c.class), i2, str);
    }

    /* access modifiers changed from: package-private */
    public boolean n(int i2, String str) {
        return true;
    }

    private static d.a a(EnumSet<c> enumSet, int i2, String str) {
        d.b bVar = new d.b();
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.n(i2, str)) {
                cVar.a(bVar);
                bVar.eN(cVar.name());
            }
        }
        return bVar;
    }
}
