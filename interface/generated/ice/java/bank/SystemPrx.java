//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.2
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package bank;

public interface SystemPrx extends com.zeroc.Ice.ObjectPrx
{
    default AccountCreationResult createAccount(UserData userData)
    {
        return createAccount(userData, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default AccountCreationResult createAccount(UserData userData, java.util.Map<String, String> context)
    {
        return _iceI_createAccountAsync(userData, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<AccountCreationResult> createAccountAsync(UserData userData)
    {
        return _iceI_createAccountAsync(userData, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<AccountCreationResult> createAccountAsync(UserData userData, java.util.Map<String, String> context)
    {
        return _iceI_createAccountAsync(userData, context, false);
    }

    /**
     * @hidden
     * @param iceP_userData -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<AccountCreationResult> _iceI_createAccountAsync(UserData iceP_userData, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<AccountCreationResult> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "createAccount", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     UserData.ice_write(ostr, iceP_userData);
                 }, istr -> {
                     AccountCreationResult ret;
                     ret = AccountCreationResult.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default UserPrx logInStandard(String pesel)
        throws InvalidCredentials
    {
        return logInStandard(pesel, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default UserPrx logInStandard(String pesel, java.util.Map<String, String> context)
        throws InvalidCredentials
    {
        try
        {
            return _iceI_logInStandardAsync(pesel, context, true).waitForResponseOrUserEx();
        }
        catch(InvalidCredentials ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<UserPrx> logInStandardAsync(String pesel)
    {
        return _iceI_logInStandardAsync(pesel, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<UserPrx> logInStandardAsync(String pesel, java.util.Map<String, String> context)
    {
        return _iceI_logInStandardAsync(pesel, context, false);
    }

    /**
     * @hidden
     * @param iceP_pesel -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<UserPrx> _iceI_logInStandardAsync(String iceP_pesel, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<UserPrx> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "logInStandard", null, sync, _iceE_logInStandard);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_pesel);
                 }, istr -> {
                     UserPrx ret;
                     ret = UserPrx.uncheckedCast(istr.readProxy());
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_logInStandard =
    {
        InvalidCredentials.class
    };

    default PremiumUserPrx logInPremium(String pesel)
        throws AuthorizationFailed,
               InvalidCredentials
    {
        return logInPremium(pesel, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default PremiumUserPrx logInPremium(String pesel, java.util.Map<String, String> context)
        throws AuthorizationFailed,
               InvalidCredentials
    {
        try
        {
            return _iceI_logInPremiumAsync(pesel, context, true).waitForResponseOrUserEx();
        }
        catch(AuthorizationFailed ex)
        {
            throw ex;
        }
        catch(InvalidCredentials ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<PremiumUserPrx> logInPremiumAsync(String pesel)
    {
        return _iceI_logInPremiumAsync(pesel, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<PremiumUserPrx> logInPremiumAsync(String pesel, java.util.Map<String, String> context)
    {
        return _iceI_logInPremiumAsync(pesel, context, false);
    }

    /**
     * @hidden
     * @param iceP_pesel -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<PremiumUserPrx> _iceI_logInPremiumAsync(String iceP_pesel, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<PremiumUserPrx> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "logInPremium", null, sync, _iceE_logInPremium);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_pesel);
                 }, istr -> {
                     PremiumUserPrx ret;
                     ret = PremiumUserPrx.uncheckedCast(istr.readProxy());
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_logInPremium =
    {
        AuthorizationFailed.class,
        InvalidCredentials.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static SystemPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), SystemPrx.class, _SystemPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static SystemPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), SystemPrx.class, _SystemPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static SystemPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), SystemPrx.class, _SystemPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static SystemPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), SystemPrx.class, _SystemPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static SystemPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, SystemPrx.class, _SystemPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static SystemPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, SystemPrx.class, _SystemPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default SystemPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (SystemPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default SystemPrx ice_adapterId(String newAdapterId)
    {
        return (SystemPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default SystemPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (SystemPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default SystemPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (SystemPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default SystemPrx ice_invocationTimeout(int newTimeout)
    {
        return (SystemPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default SystemPrx ice_connectionCached(boolean newCache)
    {
        return (SystemPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default SystemPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (SystemPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default SystemPrx ice_secure(boolean b)
    {
        return (SystemPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default SystemPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (SystemPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default SystemPrx ice_preferSecure(boolean b)
    {
        return (SystemPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default SystemPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (SystemPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default SystemPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (SystemPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default SystemPrx ice_collocationOptimized(boolean b)
    {
        return (SystemPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default SystemPrx ice_twoway()
    {
        return (SystemPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default SystemPrx ice_oneway()
    {
        return (SystemPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default SystemPrx ice_batchOneway()
    {
        return (SystemPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default SystemPrx ice_datagram()
    {
        return (SystemPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default SystemPrx ice_batchDatagram()
    {
        return (SystemPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default SystemPrx ice_compress(boolean co)
    {
        return (SystemPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default SystemPrx ice_timeout(int t)
    {
        return (SystemPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default SystemPrx ice_connectionId(String connectionId)
    {
        return (SystemPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default SystemPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (SystemPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::bank::System";
    }
}
