package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class GoogleSignIn {
    private GoogleSignIn() {
    }

    public static GoogleSignInAccount getAccountForExtension(Context context, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.i(88272);
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "please provide valid GoogleSignInOptionsExtension");
        GoogleSignInAccount lastSignedInAccount = getLastSignedInAccount(context);
        if (lastSignedInAccount == null) {
            lastSignedInAccount = GoogleSignInAccount.createDefault();
        }
        GoogleSignInAccount requestExtraScopes = lastSignedInAccount.requestExtraScopes(zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.o(88272);
        return requestExtraScopes;
    }

    public static GoogleSignInAccount getAccountForScopes(Context context, Scope scope, Scope... scopeArr) {
        AppMethodBeat.i(88271);
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(scope, "please provide at least one valid scope");
        GoogleSignInAccount lastSignedInAccount = getLastSignedInAccount(context);
        if (lastSignedInAccount == null) {
            lastSignedInAccount = GoogleSignInAccount.createDefault();
        }
        lastSignedInAccount.requestExtraScopes(scope);
        lastSignedInAccount.requestExtraScopes(scopeArr);
        AppMethodBeat.o(88271);
        return lastSignedInAccount;
    }

    public static GoogleSignInClient getClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88268);
        GoogleSignInClient googleSignInClient = new GoogleSignInClient(activity, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
        AppMethodBeat.o(88268);
        return googleSignInClient;
    }

    public static GoogleSignInClient getClient(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88267);
        GoogleSignInClient googleSignInClient = new GoogleSignInClient(context, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
        AppMethodBeat.o(88267);
        return googleSignInClient;
    }

    public static GoogleSignInAccount getLastSignedInAccount(Context context) {
        AppMethodBeat.i(88270);
        GoogleSignInAccount zzo = zzq.zze(context).zzo();
        AppMethodBeat.o(88270);
        return zzo;
    }

    public static Task<GoogleSignInAccount> getSignedInAccountFromIntent(Intent intent) {
        AppMethodBeat.i(88269);
        GoogleSignInResult signInResultFromIntent = zzi.getSignInResultFromIntent(intent);
        if (signInResultFromIntent == null) {
            Task<GoogleSignInAccount> forException = Tasks.forException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
            AppMethodBeat.o(88269);
            return forException;
        } else if (!signInResultFromIntent.getStatus().isSuccess() || signInResultFromIntent.getSignInAccount() == null) {
            Task<GoogleSignInAccount> forException2 = Tasks.forException(ApiExceptionUtil.fromStatus(signInResultFromIntent.getStatus()));
            AppMethodBeat.o(88269);
            return forException2;
        } else {
            Task<GoogleSignInAccount> forResult = Tasks.forResult(signInResultFromIntent.getSignInAccount());
            AppMethodBeat.o(88269);
            return forResult;
        }
    }

    public static boolean hasPermissions(GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.i(88273);
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        boolean hasPermissions = hasPermissions(googleSignInAccount, zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.o(88273);
        return hasPermissions;
    }

    public static boolean hasPermissions(GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.i(88274);
        if (googleSignInAccount == null) {
            AppMethodBeat.o(88274);
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, scopeArr);
        boolean containsAll = googleSignInAccount.getGrantedScopes().containsAll(hashSet);
        AppMethodBeat.o(88274);
        return containsAll;
    }

    public static void requestPermissions(Activity activity, int i2, GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.i(88275);
        Preconditions.checkNotNull(activity, "Please provide a non-null Activity");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        requestPermissions(activity, i2, googleSignInAccount, zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.o(88275);
    }

    public static void requestPermissions(Activity activity, int i2, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.i(88277);
        Preconditions.checkNotNull(activity, "Please provide a non-null Activity");
        Preconditions.checkNotNull(scopeArr, "Please provide at least one scope");
        activity.startActivityForResult(zzd(activity, googleSignInAccount, scopeArr), i2);
        AppMethodBeat.o(88277);
    }

    public static void requestPermissions(Fragment fragment, int i2, GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        AppMethodBeat.i(88276);
        Preconditions.checkNotNull(fragment, "Please provide a non-null Fragment");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        requestPermissions(fragment, i2, googleSignInAccount, zzd(googleSignInOptionsExtension.getImpliedScopes()));
        AppMethodBeat.o(88276);
    }

    public static void requestPermissions(Fragment fragment, int i2, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.i(88278);
        Preconditions.checkNotNull(fragment, "Please provide a non-null Fragment");
        Preconditions.checkNotNull(scopeArr, "Please provide at least one scope");
        fragment.startActivityForResult(zzd(fragment.getActivity(), googleSignInAccount, scopeArr), i2);
        AppMethodBeat.o(88278);
    }

    private static Intent zzd(Activity activity, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        AppMethodBeat.i(88279);
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder();
        if (scopeArr.length > 0) {
            builder.requestScopes(scopeArr[0], scopeArr);
        }
        if (googleSignInAccount != null && !TextUtils.isEmpty(googleSignInAccount.getEmail())) {
            builder.setAccountName(googleSignInAccount.getEmail());
        }
        Intent signInIntent = new GoogleSignInClient(activity, builder.build()).getSignInIntent();
        AppMethodBeat.o(88279);
        return signInIntent;
    }

    private static Scope[] zzd(List<Scope> list) {
        AppMethodBeat.i(88280);
        if (list == null) {
            Scope[] scopeArr = new Scope[0];
            AppMethodBeat.o(88280);
            return scopeArr;
        }
        Scope[] scopeArr2 = (Scope[]) list.toArray(new Scope[list.size()]);
        AppMethodBeat.o(88280);
        return scopeArr2;
    }
}
