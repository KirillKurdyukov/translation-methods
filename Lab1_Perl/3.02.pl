#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my @strings = ();

while(my $input = <>) {
    $input =~ s/<.*?>//g;
    push(@strings, $input);
}

while(scalar(@strings) > 0 && !($strings[-1] =~ /\S/)) {
    pop(@strings);
}

my $counterNotEmpty = 0;
my $counterEmpty = 0;
foreach(@strings) {
    if ($_ =~ /\S/) {
        if ($counterNotEmpty > 0) {
            print ("\n");
            if ($counterEmpty > 0) {
                $counterEmpty = 0;
                print ("\n");
            }
        }
        $_ =~ s/^(\s)+//;
        $_ =~ s/(\s)+$//;
        $_ =~ s/(\s)+/ /g;
        print($_);
        $counterNotEmpty++;
    } else {
        $counterEmpty = 1;
    }
}