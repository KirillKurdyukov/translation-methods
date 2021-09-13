#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while(<>) {
    print if /( \d+\.?\d* )|(^\d+\.?\d* )|( \d+\.?\d*$)|(^\d+\.?\d*$)/
}