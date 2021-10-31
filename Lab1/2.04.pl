#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while (<>) {
    s/(\W*)(\b\w+\b)(\W+)(\b\w+\b)(\W?)/$1$4$3$2$5/;
    print ;
}