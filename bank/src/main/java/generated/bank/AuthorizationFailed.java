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

package generated.bank;

public class AuthorizationFailed extends BankSystemException
{
    public AuthorizationFailed()
    {
        super();
    }

    public AuthorizationFailed(Throwable cause)
    {
        super(cause);
    }

    public AuthorizationFailed(String reason)
    {
        super(reason);
    }

    public AuthorizationFailed(String reason, Throwable cause)
    {
        super(reason, cause);
    }

    public String ice_id()
    {
        return "::generated::bank::AuthorizationFailed";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::generated::bank::AuthorizationFailed", -1, false);
        ostr_.endSlice();
        super._writeImpl(ostr_);
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
        super._readImpl(istr_);
    }

    /** @hidden */
    public static final long serialVersionUID = -1590459242L;
}