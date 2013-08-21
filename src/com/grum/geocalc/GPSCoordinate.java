/*
 * Copyright (c) 2012 Romain Gallet
 *
 * This file is part of Geocalc.
 *
 * Geocalc is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * Geocalc is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Geocalc. If not, see http://www.gnu.org/licenses/.
 */

package com.grum.geocalc;

/**
 * Represents coordinates given in
 * Degrees decimal-minutes (D m) format
 *
 * @author rgallet
 */
public class GPSCoordinate extends DMSCoordinate {

    public GPSCoordinate(double wholeDegrees, double minutes) {
        super(wholeDegrees, minutes, 0);
    }
}