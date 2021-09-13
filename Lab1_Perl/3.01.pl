#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my @strings = ();

while(my $input = <>) {
    push(@strings, $input);
}

while(scalar(@strings) > 0 && !($strings[-1] =~ /\S/)) {
    pop(@strings);
}

my $counterNotEmpty = 0;
foreach(@strings) {
    if ($_ =~ /\S/) {
        $_ =~ s/^(\s)+//;
        $_ =~ s/(\s)+/$1/g;
        print($_);
        $counterNotEmpty++;
    } else {
        if ($counterNotEmpty > 0) {
            print($_);
            $counterNotEmpty = 0;
        }
    }
}
