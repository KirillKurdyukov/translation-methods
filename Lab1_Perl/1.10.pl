#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while(<>) {
    print if /\b((\w|\d)+)\1\b/
}