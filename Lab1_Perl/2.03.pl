#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while (<>) {
    s/\b[A,a]+\b/argh/ ;
    print ;
}