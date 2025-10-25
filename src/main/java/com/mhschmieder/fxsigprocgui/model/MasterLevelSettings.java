/*
 * MIT License
 *
 * Copyright (c) 2020, 2025 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxSigProc Library
 *
 * You should have received a copy of the MIT License along with the
 * FxSigProc Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxsigproc
 */
package com.mhschmieder.fxsigprocgui.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MasterLevelSettings {

    private static final boolean  POLARITY_REVERSED_DEFAULT = false;
    private static final double   GAIN_DB_DEFAULT           = 0.0d;
    private static final boolean  MUTED_DEFAULT             = false;

    final BooleanProperty         polarityReversed;
    private final DoubleProperty  gain;
    private final BooleanProperty muted;

    public MasterLevelSettings() {
        this( POLARITY_REVERSED_DEFAULT, GAIN_DB_DEFAULT, MUTED_DEFAULT );
    }

    public MasterLevelSettings( final boolean pPolarityReversed,
                                final double pGain,
                                final boolean pMuted ) {
        polarityReversed = new SimpleBooleanProperty( pPolarityReversed );
        gain = new SimpleDoubleProperty( pGain );
        muted = new SimpleBooleanProperty( pMuted );
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( !( obj instanceof MasterLevelSettings ) ) {
            return false;
        }
        final MasterLevelSettings other = ( MasterLevelSettings ) obj;
        if ( gain == null ) {
            if ( other.gain != null ) {
                return false;
            }
        }
        else if ( !gain.equals( other.gain ) ) {
            return false;
        }
        if ( muted == null ) {
            if ( other.muted != null ) {
                return false;
            }
        }
        else if ( !muted.equals( other.muted ) ) {
            return false;
        }
        if ( polarityReversed == null ) {
            if ( other.polarityReversed != null ) {
                return false;
            }
        }
        else if ( !polarityReversed.equals( other.polarityReversed ) ) {
            return false;
        }
        return true;
    }

    public DoubleProperty gainProperty() {
        return gain;
    }

    public double getGain() {
        return gain.get();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + ( ( gain == null ) ? 0 : gain.hashCode() );
        result = ( prime * result ) + ( ( muted == null ) ? 0 : muted.hashCode() );
        result = ( prime * result )
                + ( ( polarityReversed == null ) ? 0 : polarityReversed.hashCode() );
        return result;
    }

    public final boolean isMuted() {
        return muted.get();
    }

    public final boolean isPolarityReversed() {
        return polarityReversed.get();
    }

    public final BooleanProperty mutedProperty() {
        return muted;
    }

    public final BooleanProperty polarityReversedProperty() {
        return polarityReversed;
    }

    public void setGain( final double pGain ) {
        gain.set( pGain );

    }

    public final void setMuted( final boolean pMuted ) {
        muted.set( pMuted );
    }

    public final void setPolarityReversed( final boolean pPolarityReversed ) {
        polarityReversed.set( pPolarityReversed );
    }
}
