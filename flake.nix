{
	description = "A port of YarnSpinner for libGDX";

	inputs = {
		nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
	};

	outputs = { self, nixpkgs, flake-utils }:
		flake-utils.lib.eachDefaultSystem(system:
			let
				pkgs = import nixpkgs { inherit system; };
				dotnet = pkgs.dotnetCorePackages.sdk_9_0-bin;
			in {
				devShells.default = pkgs.mkShellNoCC {
					# `with THING; ...;` is literally just like Kotlin's `with(THING) { ... }` >.>
					# How did I not realise that myself?!
        	buildInputs = with pkgs; [
        		protobuf
        		dotnet
        	];
        };
			}
		);
}