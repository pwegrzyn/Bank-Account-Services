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

public class PESELAlreadyInUse extends BankSystemException
{
    public PESELAlreadyInUse()
    {
        super();
    }

    public PESELAlreadyInUse(Throwable cause)
    {
        super(cause);
    }

    public PESELAlreadyInUse(String reason)
    {
        super(reason);
    }

    public PESELAlreadyInUse(String reason, Throwable cause)
    {
        super(reason, cause);
    }

    public String ice_id()
    {
        return "::bank::PESELAlreadyInUse";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::bank::PESELAlreadyInUse", -1, false);
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
    public static final long serialVersionUID = 67817228L;
}