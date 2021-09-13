#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while (<>) {
    s/\b([0-9]+)0\b/$1/g;
    print ;
}