/* Generated By:JJTree: Do not edit this line. Node.java */
/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2000-2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Velocity", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

package org.apache.velocity.runtime.parser.node;

import java.io.Writer;
import java.io.IOException;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.runtime.parser.Parser;
import org.apache.velocity.runtime.parser.Token;

import org.apache.velocity.exception.MethodInvocationException;

/**
 *  All AST nodes must implement this interface.  It provides basic
 *  machinery for constructing the parent and child relationships
 *  between nodes. 
 */

public interface Node
{

    /**
     *  This method is called after the node has been made the current
     *  node.  It indicates that child nodes can now be added to it. 
     */
    public void jjtOpen();

    /** 
     *  This method is called after all the child nodes have been
     *  added. 
     */
    public void jjtClose();

    /** 
     *  This pair of methods are used to inform the node of its
     *  parent. 
     */
    public void jjtSetParent(Node n);
    public Node jjtGetParent();

    /** 
     *  This method tells the node to add its argument to the node's
     *   list of children.  
     */
    public void jjtAddChild(Node n, int i);

    /** 
     *  This method returns a child node.  The children are numbered
     *  from zero, left to right. 
     */
    public Node jjtGetChild(int i);

    /** Return the number of children the node has. */
    public int jjtGetNumChildren();

    /** Accept the visitor. **/
    public Object jjtAccept(ParserVisitor visitor, Object data);

    public Object childrenAccept(ParserVisitor visitor, Object data);

    // added
    public Token getFirstToken();
    public Token getLastToken();
    public int getType();

    public Object init( InternalContextAdapter context, Object data) throws Exception;

    public boolean evaluate( InternalContextAdapter context)
        throws MethodInvocationException;

    public Object value( InternalContextAdapter context)
        throws MethodInvocationException;

    public boolean render( InternalContextAdapter context, Writer writer)
        throws IOException,MethodInvocationException;

    public Object execute(Object o, InternalContextAdapter context)
      throws MethodInvocationException;

    public void setInfo(int info);
    public int getInfo();

    public String literal();
    public void setInvalid();
    public boolean isInvalid();
    public int getLine();
    public int getColumn();
}
